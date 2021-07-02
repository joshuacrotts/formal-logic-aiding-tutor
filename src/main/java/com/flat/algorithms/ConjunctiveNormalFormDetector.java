package com.flat.algorithms;

import com.flat.models.treenode.*;

public class ConjunctiveNormalFormDetector {

    /**
     *
     */
    private final WffTree wffTree;

    public ConjunctiveNormalFormDetector(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    public WffTree getConjunctiveNormalForm() {
        return this.getConjunctiveNormalFormHelper(this.wffTree);
    }

    /**
     *
     * @param _tree
     */
    public WffTree getConjunctiveNormalFormHelper(WffTree _tree) {
        if (_tree.isBinaryOp()) {
            // Implications are converted via material implication.
            if (_tree.isImp()) {
                return this.getConjunctiveNormalFormHelper(this.convertImplication(_tree));
            }
            // Biconditionals are BCB'd.
            else if (_tree.isBicond()) {
                return this.getConjunctiveNormalFormHelper(this.convertBiconditional(_tree));
            }

            // Recursively call the method on the children.
            WffTree lhs = this.getConjunctiveNormalFormHelper(_tree.getChild(0));
            WffTree rhs = this.getConjunctiveNormalFormHelper(_tree.getChild(1));

            // Ors are distributed.
            if (_tree.isOr()) {
                return this.distributeOr(lhs, rhs);
            }
            // Ands are just returned.
            else if (_tree.isAnd()) {
                return _tree;
            }
        } else if (_tree.isAtom() || (_tree.isNegation() && _tree.getChild(0).isAtom())) {
            return _tree;
        } else if (_tree.isNegation()) {
            WffTree child = _tree.getChild(0);
            // Double negation.
            if (child.isNegation()) {
                return this.getConjunctiveNormalFormHelper(_tree.getChild(0).getChild(0));
            }
            // Distribute negation to AND.
            else if (child.isAnd()) {
                return this.getConjunctiveNormalFormHelper(this.convertNegatedConjunction(_tree));
            }
            // Distribute negation to OR.
            else if (child.isOr()) {
                return this.getConjunctiveNormalFormHelper(this.convertNegatedDisjunction(_tree));
            }
            // Distribute negation to IMP.
            else if (child.isImp()) {
                System.out.println(_tree.getStringRep());
                return this.getConjunctiveNormalFormHelper(this.convertNegatedImplication(_tree));
            }
            // Distribute negation to BICOND..
            else if (child.isBicond()) {
                return this.getConjunctiveNormalFormHelper(this.convertNegatedBiconditional(_tree));
            }
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
            return new OrNode(lhs, rhs);
        }
        // Now check to see if we're distributing ((A & B) | (C & D)).
        else if (lhs.getChildrenSize() > 1 && rhs.getChildrenSize() > 1 &&
                 lhs.isAnd() && rhs.isAnd()) {
            WffTree root = new AndNode();
            for (WffTree c1 : lhs.getChildren()) {
                AndNode and = new AndNode();
                for (WffTree c2 : rhs.getChildren()) {
                    OrNode or = new OrNode(c1, c2);
                    and.addChild(or);
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
                and.addChild(or);
            }
            return and;
        }
        // Now check to see if we're distributing ((A & B) | C).
        else if (rhs.getChildrenSize() <= 1 && lhs.isAnd()) {
            AndNode and = new AndNode();
            for (WffTree c1 : lhs.getChildren()) {
                OrNode or = new OrNode(c1, rhs);
                and.addChild(or);
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
        OrNode or = new OrNode(negLhs, _impNode.getChild(1));
        System.out.println(negLhs.getStringRep());
        return or;
    }

    /**
     *
     * @param _bicondNode
     * @return
     */
    private WffTree convertBiconditional(WffTree _bicondNode) {
        ImpNode impLhs = new ImpNode(_bicondNode.getChild(0), _bicondNode.getChild(1));
        ImpNode impRhs = new ImpNode(_bicondNode.getChild(1), _bicondNode.getChild(0));
        return new AndNode(impLhs, impRhs);
    }

    /**
     *
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
}
