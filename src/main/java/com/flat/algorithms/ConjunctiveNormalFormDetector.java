package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;
import com.flat.models.treenode.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class ConjunctiveNormalFormDetector {

    /**
     *
     */
    private final WffTree wffTree;

    public ConjunctiveNormalFormDetector(WffTree _wffTree) {
        this.wffTree = _wffTree.isRoot() ? _wffTree.getChild(0) : _wffTree;
    }

    /**
     *
     * @return
     */
    public WffTree getConjunctiveNormalForm() {
        return this.getConjunctiveNormalFormHelper(this.wffTree);
    }

    /**
     *
     * @param _tree
     */
    public WffTree getConjunctiveNormalFormHelper(WffTree _tree) {
        // Easiest case - atoms or negated atoms are just returned.
        if (_tree.isAtom() || _tree.isNegAtom()) {
            return _tree;
        } else if (_tree.isBinaryOp()) {
            // Implications are converted via material implication.
            if (_tree.isImp()) { return this.getConjunctiveNormalFormHelper(this.convertImplication(_tree)); }
            // Biconditionals are BCB'd.
            else if (_tree.isBicond()) { return this.getConjunctiveNormalFormHelper(this.convertBiconditional(_tree)); }

            // Recursively call the method on the children.
            WffTree lhs = this.getConjunctiveNormalFormHelper(_tree.getChild(0));
            WffTree rhs = this.getConjunctiveNormalFormHelper(_tree.getChild(1));

            // Ors are distributed. We need to check whether we need to recursively distribute.
            if (_tree.isOr()) {
                WffTree distributedOr = this.distributeOr(lhs, rhs);
                // First we check to see if we found a tautology or equivalence. If so, this is NOT a binop.
                if (!distributedOr.isBinaryOp()) { return distributedOr; }

                // Now we check for recursive distributions.
                WffTree newLhs = distributedOr.getChild(0);
                WffTree newRhs = distributedOr.getChild(1);
                if (distributedOr.isOr()) {
                    return new OrNode(this.getConjunctiveNormalFormHelper(newLhs),
                                      this.getConjunctiveNormalFormHelper(newRhs));
                } else {
                    return new AndNode(this.getConjunctiveNormalFormHelper(newLhs),
                                       this.getConjunctiveNormalFormHelper(newRhs));
                }
            }
            // Ands are just returned TODO implement what AND should actually do...
            else if (_tree.isAnd()) { return new AndNode(lhs, rhs); }
        } else if (_tree.isNegation()) {
            WffTree child = _tree.getChild(0);
            // Double negation.
            if (child.isNegation()) { return this.getConjunctiveNormalFormHelper(_tree.getChild(0).getChild(0)); }
            // Distribute negation to AND.
            else if (child.isAnd()) { return this.getConjunctiveNormalFormHelper(this.convertNegatedConjunction(_tree)); }
            // Distribute negation to OR.
            else if (child.isOr()) { return this.getConjunctiveNormalFormHelper(this.convertNegatedDisjunction(_tree)); }
            // Distribute negation to IMP.
            else if (child.isImp()) { return this.getConjunctiveNormalFormHelper(this.convertNegatedImplication(_tree)); }
            // Distribute negation to BICOND..
            else if (child.isBicond()) { return this.getConjunctiveNormalFormHelper(this.convertNegatedBiconditional(_tree)); }
        }

         throw new IllegalStateException("Cannot convert node to CNF - this should never happen.");
    }

    /**
     *
     * @return
     */
    private WffTree distributeOr(WffTree lhs, WffTree rhs) {
        // First check to see if we're not distributing anything.
        if (!lhs.isAnd() && !rhs.isAnd()) {
            OrNode or = new OrNode(lhs, rhs);
            if (this.isTautology(or)) { return new TruthNode(); }
            else if (lhs.stringEquals(rhs)) { return lhs; }
            return or;
        }
        // Now check to see if we're distributing ((A & B) | (C & D)). We can only do this
        // when both are binary operators and at least ONE is an AND.
        else if (lhs.getChildrenSize() > 1 && rhs.getChildrenSize() > 1 &&
                (lhs.isAnd() || rhs.isAnd())) {
            WffTree root = new AndNode();
            for (WffTree c1 : lhs.getChildren()) {
                AndNode and = new AndNode();
                for (WffTree c2 : rhs.getChildren()) {
                    OrNode or = new OrNode(c1, c2);
                    if (this.isTautology(or)) and.addChild(new TruthNode());
                    else if (c1.stringEquals(c2)) and.addChild(c1);
                    else and.addChild(or);
                }
                root.addChild(and);
            }
            return root;
        }
        // Now check to see if we're distributing (A | (B & C)).
        else if (lhs.getChildrenSize() <= 1 && rhs.isAnd()){
            AndNode and = new AndNode();
            for (WffTree c2 : rhs.getChildren()) {
                OrNode or = new OrNode(lhs, c2);
                if (this.isTautology(or)) and.addChild(new TruthNode());
                else if (lhs.stringEquals(c2)) and.addChild(lhs);
                else and.addChild(or);
            }
            return and;
        }
        // Now check to see if we're distributing ((A & B) | C).
        else if (rhs.getChildrenSize() <= 1 && lhs.isAnd()) {
            AndNode and = new AndNode();
            for (WffTree c1 : lhs.getChildren()) {
                OrNode or = new OrNode(c1, rhs);
                if (this.isTautology(or)) and.addChild(new TruthNode());
                else if (c1.stringEquals(rhs)) and.addChild(c1);
                else and.addChild(or);
            }
            return and;
        }

        throw new IllegalStateException("Unable to distribute OR... this should never happen.");
    }

    /**
     *
     * @param _impNode
     * @return
     */
    private WffTree convertImplication(WffTree _impNode) {
        NegNode negLhs = new NegNode(_impNode.getChild(0));
        return new OrNode(negLhs, _impNode.getChild(1));
    }

    /**
     *
     * @param _bicondNode
     * @return
     */
    private WffTree convertBiconditional(WffTree _bicondNode) {
        AndNode andLhs = new AndNode(_bicondNode.getChild(0), _bicondNode.getChild(1));
        AndNode andRhs = new AndNode(new NegNode(_bicondNode.getChild(0)), new NegNode(_bicondNode.getChild(1)));
        return new OrNode(andLhs, andRhs);
    }

    /**
     *((A ∨ B) & (A ∨ ((C ∨ D) & (C ∨ E)))), (((B ∨ A) ∧ ((D ∨ C) ∨ A)) ∧ ((E ∨ C) ∨ A))
     * @param _wffTree
     * @return
     */
    private WffTree convertNegatedConjunction(WffTree _wffTree) {
        WffTree andNode = _wffTree.getChild(0);
        NegNode lhs = new NegNode(andNode.getChild(0));
        NegNode rhs = new NegNode(andNode.getChild(1));
        return new OrNode(lhs, rhs);
    }

    /**
     *
     * @param _wffTree
     * @return
     */
    private WffTree convertNegatedDisjunction(WffTree _wffTree) {
        WffTree orNode = _wffTree.getChild(0);
        NegNode lhs = new NegNode(orNode.getChild(0));
        NegNode rhs = new NegNode(orNode.getChild(1));
        return new AndNode(lhs, rhs);
    }

    /**
     *
     * @param _wffTree
     * @return
     */
    private WffTree convertNegatedImplication(WffTree _wffTree) {
        WffTree impNode = _wffTree.getChild(0);
        NegNode negRhs = new NegNode(impNode.getChild(1));
        return new AndNode(impNode.getChild(0), negRhs);
    }

    /**
     *
     * @param _wffTree
     * @return
     */
    private WffTree convertNegatedBiconditional(WffTree _wffTree) {
        WffTree bicondNode = _wffTree.getChild(0);
        ImpNode impLhs = new ImpNode(bicondNode.getChild(0), bicondNode.getChild(1));
        ImpNode impRhs = new ImpNode(bicondNode.getChild(1), bicondNode.getChild(0));
        NegNode negLhs = new NegNode(impLhs);
        NegNode negRhs = new NegNode(impRhs);
        return new OrNode(negLhs, negRhs);
    }

    /**
     *
     * @param _wffTree
     */
    private WffTree removeTautologiesAndFalsehoods(WffTree _wffTree) {
        WffTree root = new WffTree();
        root.addChild(_wffTree.copy());
        this.removeTautologiesAndFalsehoodsHelper(root);
        return root.getChild(0);
    }

    /**
     *
     * @param _wffTree
     */
    private void removeTautologiesAndFalsehoodsHelper(WffTree _wffTree) {
        for (int i = 0; i < _wffTree.getChildrenSize(); i++) {
            WffTree child = _wffTree.getChild(i);
            if (child.isBinaryOp()) {
                WffTree lhs = child.getChild(0);
                WffTree rhs = child.getChild(1);
                if (child.isAnd()) {
                    if (lhs.isTrue()) {
                        _wffTree.setChild(i, rhs);
                    } else if (rhs.isTrue()) {
                        _wffTree.setChild(i, lhs);
                    }
                }
            }

            this.removeTautologiesAndFalsehoodsHelper(child);
        }
    }

    /**
     *
     * @param _tree
     * @return
     */
    private boolean isTautology(WffTree _tree) {
        // Remember to add support for flipping the true and false nodes!!!!! Should be simple af.
        return _tree.isOr() && (BaseTruthTreeGenerator.getFlippedNode(_tree.getChild(0)).stringEquals(_tree.getChild(1))
                || BaseTruthTreeGenerator.getFlippedNode(_tree.getChild(1)).stringEquals(_tree.getChild(0)));
    }

    /**
     *
     * @param _tree
     * @return
     */
    private boolean isFalsehood(WffTree _tree) {
        return _tree.isAnd() && (BaseTruthTreeGenerator.getFlippedNode(_tree.getChild(0)).stringEquals(_tree.getChild(1))
                || BaseTruthTreeGenerator.getFlippedNode(_tree.getChild(1)).stringEquals(_tree.getChild(0)));
    }
}
