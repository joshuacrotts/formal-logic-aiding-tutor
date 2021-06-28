package com.flat.algorithms.propositional;

import com.flat.algorithms.ArgumentTruthTreeValidator;
import com.flat.algorithms.BaseNaturalDeductionValidator;
import com.flat.algorithms.BaseTruthTreeGenerator;
import com.flat.algorithms.models.NDFlag;
import com.flat.algorithms.models.NDStep;
import com.flat.algorithms.models.NDWffTree;
import com.flat.algorithms.models.ProofType;
import com.flat.models.treenode.*;

import java.util.ArrayList;

/**
 *
 */
public final class PropositionalNaturalDeductionValidator extends BaseNaturalDeductionValidator {

    /**
     *
     */
    private static final int TIMEOUT = 1000;

    public PropositionalNaturalDeductionValidator(ArrayList<WffTree> _wffTreeList, ProofType _proofType) {
        super(_wffTreeList, _proofType);
    }

    /**
     * Computes a natural deduction proof for a propositional logic formula. We use a couple of heuristics to ensure
     * the runtime/search space isn't COMPLETELY insane (those being that we only apply certain rules if others fail
     * to produce meaningful results, etc.).
     *
     * @return list of NDWffTree "args". These serve as the premises, with the last element in the list being
     * the conclusion.
     */
    @Override
    public ArrayList<NDWffTree> getNaturalDeductionProof() {
        ArgumentTruthTreeValidator truthTreeValidator = new ArgumentTruthTreeValidator(this.originalWffTreeList);
        if (!truthTreeValidator.isValid()) { return null; }

        int cycles = 0;
        while (true) {
            // Check for a contradiction, the conclusion, and a timeout.
            // If we are in an indirect proof, we can only break via contr and timeouts.
            boolean timeout = cycles++ > PropositionalNaturalDeductionValidator.TIMEOUT;
            if (this.proofType == ProofType.INDIRECT) {
                if (this.findContradictions() || timeout) break;
            } else {
                if (this.findConclusion() || this.findContradictions() || timeout) break;
            }

            // First try to satisfy all available premises.
            for (int i = 0; i < this.premisesList.size(); i++) {
                NDWffTree premise = this.premisesList.get(i);
                if (this.satisfy(premise.getWffTree(), premise)) {
                    premise.setFlags(NDFlag.SAT);
                }
            }

            // Now try to satisfy the conclusion and its equivalences.
            this.satisfy(this.conclusionWff.getWffTree(), this.conclusionWff);
            for (NDWffTree conclusionEquivalence : this.findConclusionEquivalentsPL()) {
                this.satisfy(conclusionEquivalence.getWffTree(), conclusionEquivalence);
            }
        }

        // The timeout is there to prevent completely insane proofs from never ending.
        if (cycles > PropositionalNaturalDeductionValidator.TIMEOUT) { return null; }

        // Go through and replace the sorted assumptions with the original indices.
        for (int r = 0; r < this.originalPremisesList.size(); r++) { this.premisesList.set(r, this.originalPremisesList.get(r)); }

        // Backtrack from the conclusion to mark all those nodes that were used in the proof.
        this.activateLinks(this.conclusionWff);

        // Add the premises that were actually used in the argument.
        return this.assignParentIndices();
    }

    /**
     * Creates a list of equivalent forms of the conclusion to see if we have
     * satisfied any of them. If so, we convert that premise into the equivalent
     * form and say that we satisfied the conclusion and proof. There are four
     * equivalences:
     *
     * Double Negation ~~C
     * Transposition C = (A -> B) <> (~B -> ~A)
     * DeMorgan's Laws
     * Material Implication C = (A -> B) <> (~A | B)
     *
     * @return ArrayList of equivalent forms of the conclusion if they exist.
     */
    protected ArrayList<NDWffTree> findConclusionEquivalentsPL() {
        ArrayList<NDWffTree> conclusionEquivalentList = new ArrayList<>();
        WffTree conclusionNode = this.conclusionWff.getWffTree();
        // First do a double negation equivalence.
        if (conclusionNode.isDoubleNegation()) {
            conclusionEquivalentList.add(new NDWffTree(conclusionNode.getChild(0).getChild(0), NDFlag.TP | NDFlag.DNE | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.DNE, this.conclusionWff));
        }

        // Now do a transposition equivalence.
        if (conclusionNode.isImp()) {
            ImpNode transpositionNode = new ImpNode();
            transpositionNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(1)));
            transpositionNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0)));
            this.conclusionWff.setFlags(NDFlag.TP);
            conclusionEquivalentList.add(new NDWffTree(transpositionNode, NDFlag.TP | NDFlag.DNE | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.TP, this.conclusionWff));
        }

        // Now do a demorgan's equivalence.
        if (conclusionNode.isNegation() || conclusionNode.isBinaryOp()) {
            WffTree deMorganNode = null;
            // Negate a biconditional to get ~(X <-> Y) => ~((X->Y) & (Y->X)).
            if (conclusionNode.isNegation() && conclusionNode.getChild(0).isBicond()) {
                NegNode neg = new NegNode();
                AndNode and = new AndNode();
                ImpNode lhs = new ImpNode();
                ImpNode rhs = new ImpNode();
                lhs.addChild(conclusionNode.getChild(0).getChild(0));
                lhs.addChild(conclusionNode.getChild(0).getChild(1));
                rhs.addChild(conclusionNode.getChild(0).getChild(1));
                rhs.addChild(conclusionNode.getChild(0).getChild(0));
                and.addChild(lhs);
                and.addChild(rhs);
                neg.addChild(and);
                deMorganNode = neg;
            }
            // "Unnegate" a conjunction with two implications to get the negated biconditional.
            else if (conclusionNode.isNegation() && conclusionNode.getChild(0).isAnd()
                    && conclusionNode.getChild(0).getChild(0).isImp() && conclusionNode.getChild(0).getChild(1).isImp()
                    && conclusionNode.getChild(0).getChild(0).getChild(0).stringEquals(conclusionNode.getChild(0).getChild(1).getChild(1))
                    && conclusionNode.getChild(0).getChild(0).getChild(1).stringEquals(conclusionNode.getChild(0).getChild(1).getChild(0))) {
                NegNode negNode = new NegNode();
                BicondNode bicondNode = new BicondNode();
                bicondNode.addChild(conclusionNode.getChild(0).getChild(0).getChild(0));
                bicondNode.addChild(conclusionNode.getChild(0).getChild(0).getChild(1));
                negNode.addChild(bicondNode);
                deMorganNode = negNode;
            }
            // Two types: one is ~(X B Y) => (~X ~B ~Y)
            else if (conclusionNode.isNegation() && (conclusionNode.getChild(0).isOr() || conclusionNode.getChild(0).isAnd() || conclusionNode.getChild(0).isImp())) {
                deMorganNode = BaseTruthTreeGenerator.getNegatedBinaryNode(conclusionNode.getChild(0)); // B
                deMorganNode.addChild(conclusionNode.getChild(0).isImp() ? conclusionNode.getChild(0).getChild(0)
                        : BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0).getChild(0))); // LHS X
                deMorganNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0).getChild(1))); // RHS Y
            }
            // Other is (X B Y) => ~(~X ~B ~Y)
            else if ((conclusionNode.isOr() || conclusionNode.isAnd() || conclusionNode.isImp())) {
                WffTree negBinaryNode = BaseTruthTreeGenerator.getNegatedBinaryNode(conclusionNode); // B
                negBinaryNode.addChild(conclusionNode.isImp() ? conclusionNode.getChild(0) : BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(0))); // LHS X
                negBinaryNode.addChild(BaseTruthTreeGenerator.getFlippedNode(conclusionNode.getChild(1))); // RHS Y
                deMorganNode = new NegNode();
                deMorganNode.addChild(negBinaryNode);
            }
            // If we found a node, then it'll be applied/inserted here.
            if (deMorganNode != null) {
                this.conclusionWff.setFlags(NDFlag.DEM);
                conclusionEquivalentList.add(new NDWffTree(deMorganNode, NDFlag.TP | NDFlag.DNE | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.DEM, this.conclusionWff));
            }
        }

        // Finally, do a material implication equivalence.
        if (conclusionNode.isImp() || conclusionNode.isOr()) {
            WffTree newWff = null;
            // Convert (P -> Q) to (~P V Q).
            if (conclusionNode.isImp()) {
                OrNode orNode = new OrNode();
                NegNode negLhs = new NegNode();
                negLhs.addChild(conclusionNode.getChild(0));
                orNode.addChild(negLhs);
                orNode.addChild(conclusionNode.getChild(1));
                newWff = orNode;
            }
            // Convert (~P V Q) to (P -> Q)
            else if (conclusionNode.isOr()) {
                WffTree lhs = conclusionNode.getChild(0);
                WffTree rhs = conclusionNode.getChild(1);
                if (lhs.isNegation()) {
                    ImpNode impNode = new ImpNode();
                    impNode.addChild(lhs.getChild(0)); // Un-negate the lhs.
                    impNode.addChild(rhs);
                    newWff = impNode;
                }
            }
            // If we performed a MI then add it.
            if (newWff != null) {
                this.conclusionWff.setFlags(NDFlag.MI);
                NDWffTree ndWffTree = new NDWffTree(newWff, NDFlag.TP | NDFlag.DNE | NDFlag.DEM | NDFlag.MI | NDFlag.ALTC, NDStep.MI, this.conclusionWff);
                conclusionEquivalentList.add(ndWffTree);
            }
        }
        return conclusionEquivalentList;
    }

    /**
     * Determines if we can "satisfy" a premise Wff W. W is satisfied when it is used in
     * the reduction or expansion of another Wff W'. In other words, if W is used to construct
     * W', W is satisfied. The idea is to recursively compute "goals" for a premise, then
     * by determining if those goals are satisfied, we can construct the overall goal.
     * <p>
     * For example, suppose the goal is (A & B). The subgoals are then A and B. If A and B are
     * premises, these goals are satisfied by default. Thus, the overarching goal is satisfied.
     * Different rules apply for different operators.
     * <p>
     * We pass both the parent NDWffTree as well as the WffTree since we cannot break down the
     * parent NDwffTree's WffTree - we can only recursively pass the children of _tree.
     *
     * @param _tree   - WffTree object to recursively check for satisfaction.
     * @param _parent - NDWffTree "parent" of _tree; any children of _tree will be temporary "children" of _parent.
     * @return
     */
    private boolean satisfy(WffTree _tree, NDWffTree _parent) {
        boolean satisfied = false;
        // First, try out the standard rules that are easily deducible.
        if (this.findDeMorganEquivalence(_tree, _parent)) {
            return true;
        } else if (this.findMaterialImplication(_tree, _parent)) {
            return true;
        } else if (_tree.isImp()) {
            satisfied = this.satisfyImplication(_tree, _parent);
        } else if (_tree.isAnd()) {
            satisfied = this.satisfyConjunction(_tree, _parent);
        } else if (_tree.isOr()) {
            satisfied = this.satisfyDisjunction(_tree, _parent);
        } else if (_tree.isBicond()) {
            satisfied = this.satisfyBiconditional(_tree, _parent);
        }

        // Now we can try to find different equivalences with transposition, CD and DD.
        if (this.findTransposition(_tree, _parent)) {
            return true;
        } else if (this.findConstructiveDilemma(_tree, _parent)) {
            return true;
        } else if (this.findDestructiveDilemma(_tree, _parent)) {
            return true;
        } else if (this.findDoubleNegations(_tree, _parent)) {
            return true;
        }

        // If we couldn't find anything to deduce/reduce the proposition with,
        // try to search for it in the premises list.
        for (NDWffTree ndWffTree : this.premisesList) {
            if (ndWffTree.getWffTree().stringEquals(_tree)) {
                return true;
            }
        }

        return satisfied;
    }

    /**
     * Satisfying an implication nodes comes through for primary methods:
     * <p>
     * 1. Modus Ponens (P -> Q), P therefore Q
     * 2. Modus Tollens (P -> Q), ~Q therefore ~P
     * 3. Hypothetical Syllogism (P->Q), (Q->R) therefore (P->R)
     * 4. Construction of (P -> Q) from P and Q.
     *
     * @param _impTree - implication node to check for satisfaction.
     * @param _parent  - parent NDWffTree.
     * @return true if we can satisfy the implication goal, false otherwise.
     */
    private boolean satisfyImplication(WffTree _impTree, NDWffTree _parent) {
        // If the parent is not the conclusion then we can attempt to do other rules on it.
        if (!this.isConclusion(_parent) && _impTree.stringEquals(_parent.getWffTree())) {
            boolean mp = this.findModusPonens(_impTree, _parent);
            boolean mt = this.findModusTollens(_impTree, _parent);
            boolean hs = this.findHypotheticalSyllogism(_impTree, _parent);
            if (mt || mp || hs) { return true; }
        }

        // Otherwise, try to construct an implication node - see if both sides are satisfiable.
        if (this.satisfy(_impTree.getChild(0), _parent) && this.satisfy(_impTree.getChild(1), _parent)) {
            ImpNode impNode = new ImpNode();
            impNode.addChild(_impTree.getChild(0));
            impNode.addChild(_impTree.getChild(1));
            this.addPremise(new NDWffTree(impNode, NDFlag.II, NDStep.II,
                    this.getPremiseNDWffTree(_impTree.getChild(0)),
                    this.getPremiseNDWffTree(_impTree.getChild(1))));
            return true;
        }

        return false;
    }

    /**
     * Creates or eliminates a conjunction node. The creation comes through searching for
     * the two operands to see if they exist and if so, create the conjunction.
     * <p>
     * Elimination is simply simplification - breaks the two operands down.
     *
     * @param _conjTree - conjunction node.
     * @param _parent - parent of conjunction node.
     * @return true if we can satisfy the conjunction goal, false otherwise.
     */
    private boolean satisfyConjunction(WffTree _conjTree, NDWffTree _parent) {
        // First try to simplify if the root is a conjunction.
        if (!this.isConclusion(_parent) && _conjTree.stringEquals(_parent.getWffTree())) {
            if (this.findSimplification(_conjTree, _parent)) return true;
        }

        // Then try to create a conjunction if it's a goal and satisfied on both sides.
        if (this.satisfy(_conjTree.getChild(0), _parent)
                && this.satisfy(_conjTree.getChild(1), _parent)) {
            AndNode andNode = new AndNode();
            andNode.addChild(_conjTree.getChild(0));
            andNode.addChild(_conjTree.getChild(1));
            this.addPremise(new NDWffTree(andNode, NDFlag.AI, NDStep.AI,
                    this.getPremiseNDWffTree(_conjTree.getChild(0)),
                    this.getPremiseNDWffTree(_conjTree.getChild(1))));
            return true;
        }
        return false;
    }

    /**
     * Attempts to satisfy a disjunction. There are two preconditions:
     *
     * @precondition _parent cannot be the conclusion.
     * @precondition _disjTree must be the same WffTree as the _parent's.
     *
     * A disjunction is satisfied either through disjunctive syllogism OR
     * through the creation of a disjunction. Creations are satisfied via
     * the satisfaction of one or both of their children. More details are
     * outlined below.
     *
     * @param _disjTree - disjunction node.
     * @param _parent - parent of the disjunction.
     * @return true if we can satisfy the disjunction goal, false otherwise.
     */
    private boolean satisfyDisjunction(WffTree _disjTree, NDWffTree _parent) {
        // First try to perform DS if the root is a disjunction.
        if (!this.isConclusion(_parent) && _disjTree.stringEquals(_parent.getWffTree())) {
            if (this.findDisjunctiveSyllogism(_disjTree, _parent)) return true;
        }

        // Then try to create a conjunction if it's a goal and one of the two children are satisfied.
        if (this.satisfy(_disjTree.getChild(0), _parent) || this.satisfy(_disjTree.getChild(1), _parent)) {
            // There's two conditions: we're either adding from the conclusion or from
            // another premise. If the parent is the conclusion, then we're adding from
            // that (obviously) and one of the nodes won't be retrievable via getPremise....
            OrNode orNode = new OrNode();
            orNode.addChild(_disjTree.getChild(0));
            orNode.addChild(_disjTree.getChild(1));

            // Find out which operand is null (if any).
            NDWffTree lhsDisj = this.getPremiseNDWffTree(_disjTree.getChild(0));
            NDWffTree rhsDisj = this.getPremiseNDWffTree(_disjTree.getChild(1));
            if (this.isConclusion(_parent)) {
                if (lhsDisj == null) {
                    lhsDisj = new NDWffTree(_disjTree.getChild(0), NDStep.OI);
                } else {
                    rhsDisj = new NDWffTree(_disjTree.getChild(1), NDStep.OI);
                }
            }
            this.addPremise(new NDWffTree(orNode, NDFlag.OI, NDStep.OI, lhsDisj, rhsDisj));
            return true;
        }
        return false;
    }

    /**
     * Attempts to satisfy a biconditional. There are two preconditions:
     *
     * @precondition _parent cannot be the conclusion.
     * @precondition _bicondTree must represent the same tree as _parent.
     *
     * A biconditional is satisfied via either a BCE rule, or the creation of
     * a biconditional via two implications conjoined with &.
     *
     * @param _bicondTree - biconditional WffTree
     * @param _parent - parent of _bicondTree.
     * @return true if we can satisfy the biconditional goal, false otherwise.
     */
    private boolean satisfyBiconditional(WffTree _bicondTree, NDWffTree _parent) {
        // First check to see if we can break any biconditionals down.
        if (!this.isConclusion(_parent) && _bicondTree.stringEquals(_parent.getWffTree())) {
            if (this.findBiconditionalElimination(_bicondTree, _parent)) return true;
        }
        // We first have a subgoal of X -> Y and Y -> X.
        ImpNode impLhs = new ImpNode();
        ImpNode impRhs = new ImpNode();
        impLhs.addChild(_bicondTree.getChild(0));
        impLhs.addChild(_bicondTree.getChild(1));
        impRhs.addChild(_bicondTree.getChild(1));
        impRhs.addChild(_bicondTree.getChild(0));

        // Check to see if both implications are satisfied.
        if (this.satisfy(impLhs, _parent) && this.satisfy(impRhs, _parent)) {
            BicondNode bicondNode = new BicondNode();
            bicondNode.addChild(_bicondTree.getChild(0));
            bicondNode.addChild(_bicondTree.getChild(1));
            this.addPremise(new NDWffTree(bicondNode, NDFlag.BC, NDStep.BCI,
                    this.getPremiseNDWffTree(impLhs),
                    this.getPremiseNDWffTree(impRhs)));
            return true;
        }
        return false;
    }
}
