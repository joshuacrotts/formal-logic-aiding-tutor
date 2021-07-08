package com.flat.algorithms;

import com.flat.algorithms.models.NDFlag;
import com.flat.algorithms.models.NDStep;
import com.flat.algorithms.models.NDWffTree;
import com.flat.input.FLATParserAdapter;
import com.flat.models.treenode.NodeType;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public final class NaturalDeductionProofVerifier {

    /**
     * Premises list - this is updated throughout the verification.
     */
    private final ArrayList<NDWffTree> premisesList;

    /**
     * Conclusion NDWffTree - this is the last element in the original WffTree list.
     */
    private final NDWffTree conclusionWff;

    public NaturalDeductionProofVerifier(ArrayList<WffTree> _wffTreeList) {
        this.premisesList = new ArrayList<>();
        this.conclusionWff = new NDWffTree(_wffTreeList.get(_wffTreeList.size() - 1).getNodeType() == NodeType.ROOT
                ? _wffTreeList.get(_wffTreeList.size() - 1).getChild(0)
                : _wffTreeList.get(_wffTreeList.size() - 1), NDStep.C);

        // Add all premises to the list. The invariant is that the last element is guaranteed to be the conclusion.
        for (int i = 0; i < _wffTreeList.size() - 1; i++) {
            // Trim ROOT off the node if it's still there from ANTLR processing.
            WffTree wff = _wffTreeList.get(i).getNodeType() == NodeType.ROOT
                    ? _wffTreeList.get(i).getChild(0)
                    : _wffTreeList.get(i);
            this.addPremise(new NDWffTree(wff, NDFlag.ACTIVE, NDStep.P));
        }
    }

    /**
     * Adds one step to this natural deduction proof. Returns whether or not this step derived the
     * conclusion of the proof or not.
     *
     * @param _wffTree - single WffTree to be used as the next premise.
     * @param _step - step that is being derived.
     * @param _values - integer list in the form of a string e.g., "1, 2, 3".
     * @return true if this premise derived the conclusion, false otherwise.
     */
    public boolean proveNaturalDeduction(WffTree _wffTree, NDStep _step, String _values) {
        // Trim the root if it is a root node.
        _wffTree = _wffTree.isRoot() ? _wffTree.getChild(0) : _wffTree;
        // Remove all spaces in the parent string of indices.
        _values = _values.replaceAll("\\s+", "");
        // Now split at the comma to get the numbers.
        int[] nums = this.convertToIntArray(_values.split(","));
        if (!this.isValidStep(_wffTree, _step, nums)) return false;
        this.assignParentIndices();
        return this.findConclusion();
    }

    /**
     *
     */
    public void proveNaturalDeductionStdin() {
        Scanner stdin = new Scanner(System.in);
        while (!this.findConclusion()) {
            this.assignParentIndices();
            this.displayArgument();
            System.out.println("Enter next premise in the format: \"WFF, STEP; N,N0,...\"");
            // Remove all whitespace.
            String nextArg = stdin.nextLine().replaceAll("\\s+", "");
            // Get the three components.
            String wff = nextArg.substring(0, nextArg.indexOf(","));
            NDStep step = this.getStep(nextArg.substring(nextArg.indexOf(",") + 1, nextArg.indexOf(";")));
            int[] nums = this.convertToIntArray(nextArg.substring(nextArg.indexOf(";") + 1).split(","));
            // Convert the string input to a WffTree list - this should be a singleton.
            ArrayList<WffTree> wffTreeList = FLATParserAdapter.getAbstractSyntaxTree(wff);
            // Trim the root if necessary (almost always is).
            WffTree wffTree = wffTreeList.get(0).isRoot() ? wffTreeList.get(0).getChild(0) : wffTreeList.get(0);
            if (!this.isValidStep(wffTree, step, nums)) {
                throw new IllegalArgumentException("Invalid rule applied.");
            }
        }
        System.out.println("Congratulations, the proof is complete.");
        this.assignParentIndices();
        this.displayArgument();
    }

    /**
     * Determines if a WffTree, NDStep, and parent indices create a valid step for the
     * natural deduction proof.
     *
     * @param _wffTree
     * @param _step
     * @param _parents
     * @return
     */
    private boolean isValidStep(WffTree _wffTree, NDStep _step, int[] _parents) {
        if (_parents.length != _step.getOpCount()) {
            throw new IllegalArgumentException(_step + " requires " + _step.getOpCount() + " parent(s) to derive but was provided " + _parents.length);
        }

        switch (_step) {
            case MP: return this.isValidModusPonens(_wffTree, _parents);
            case MT: return this.isValidModusTollens(_wffTree, _parents);
            case AE: return this.isValidConjunctionElimination(_wffTree, _parents);
            case AI: return this.isValidConjunctionIntroduction(_wffTree, _parents);
            case II: return this.isValidImplicationIntroduction(_wffTree, _parents);
            case OI: return this.isValidDisjunctionIntroduction(_wffTree, _parents);
            case HS: return this.isValidHypotheticalSyllogism(_wffTree, _parents);
            case DS: return this.isValidDisjunctiveSyllogism(_wffTree, _parents);
            case DNE: return this.isValidDoubleNegationElimination(_wffTree, _parents);
            case DNI: return this.isValidDoubleNegationIntroduction(_wffTree, _parents);
            case BCB: return this.isValidBiconditionalElimination(_wffTree, _parents);
            case BCI: return this.isValidBiconditionalIntroduction(_wffTree, _parents);
            default: throw new IllegalArgumentException(_step + " is currently unsupported.");
        }
    }

    public NDWffTree getConclusionWff() {
        return this.conclusionWff;
    }

    public ArrayList<NDWffTree> getPremisesList() {
        return this.premisesList;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidModusPonens(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // At least one of them has to be an implication.
        if (parentOne.getWffTree().isImp() || parentTwo.getWffTree().isImp()) {
            NDWffTree impNode = parentOne.getWffTree().isImp() ? parentOne : parentTwo;
            NDWffTree othNode = parentOne.getWffTree().isImp() ? parentTwo : parentOne;
            // Check to see if the antecedent of the imp node is equal to the oth node AND
            // the wfftree parameter is the consequent of the imp.
            if ((impNode.getWffTree().getChild(0).stringEquals(othNode.getWffTree()) && impNode.getWffTree().getChild(1).stringEquals(_wffTree))
                    || ((othNode.getWffTree().getChild(0).stringEquals(impNode.getWffTree()) && (othNode.getWffTree().getChild(1).stringEquals(_wffTree))))){
                this.addPremise(new NDWffTree(_wffTree, NDStep.MP, parentOne, parentTwo));
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidModusTollens(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // At least one of them has to be an implication.
        if (parentOne.getWffTree().isImp() || parentTwo.getWffTree().isImp()) {
            NDWffTree impNode = parentOne.getWffTree().isImp() ? parentOne : parentTwo;
            NDWffTree othNode = parentOne.getWffTree().isImp() ? parentTwo : parentOne;
            // We need to check quite a few conditions here. First let's check to see if flipping the implication nodes
            // satisfies the MT property.
            if ((impNode.getWffTree().getChild(1).stringEquals(BaseTruthTreeGenerator.getFlippedNode(othNode.getWffTree()))
                    && _wffTree.stringEquals(BaseTruthTreeGenerator.getFlippedNode(impNode.getWffTree().getChild(0))))
                || (othNode.getWffTree().stringEquals(BaseTruthTreeGenerator.getFlippedNode(impNode.getWffTree().getChild(1)))
                    && _wffTree.stringEquals(BaseTruthTreeGenerator.getFlippedNode(impNode.getWffTree().getChild(0))))) {
                this.addPremise(new NDWffTree(_wffTree, NDStep.MT, parentOne, parentTwo));
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidConjunctionElimination(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        // The node has to be a conjunction and one of the operands must be the WffTree.
        if (parentOne.getWffTree().isAnd()) {
            if (parentOne.getWffTree().getChild(0).stringEquals(_wffTree)
                    || parentOne.getWffTree().getChild(1).stringEquals(_wffTree)){
                this.addPremise(new NDWffTree(_wffTree, NDStep.AE, parentOne));
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidConjunctionIntroduction(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // Two conditions: 1. the new Wff must be a conjunction and its operands must be parentOne/Two.
        if (_wffTree.isAnd()) {
            if (_wffTree.getChild(0).stringEquals(parentOne.getWffTree())
             && _wffTree.getChild(1).stringEquals(parentTwo.getWffTree())) {
                this.addPremise(new NDWffTree(_wffTree, NDStep.AI, parentOne, parentTwo));
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidImplicationIntroduction(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // The WffTree must be an implication and parentOne must be the lhs and parentTwo the rhs.
        if (_wffTree.isImp()) {
            if (_wffTree.getChild(0).stringEquals(parentOne.getWffTree())
             && _wffTree.getChild(1).stringEquals(parentTwo.getWffTree())) {
                this.addPremise(new NDWffTree(_wffTree, NDStep.II, parentOne, parentTwo));
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidDisjunctionIntroduction(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        // The node has to be a disjunction and at least one of the children must be parentOne.
        if (_wffTree.isOr()) {
            if (_wffTree.getChild(0).stringEquals(parentOne.getWffTree())
             || _wffTree.getChild(1).stringEquals(parentOne.getWffTree())) {
                this.addPremise(new NDWffTree(_wffTree, NDStep.OI, parentOne));
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidHypotheticalSyllogism(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // The condition is that the two parents must be implications and the
        // current node must be an implication and the HS property must be satisfied.
        if (_wffTree.isImp()) {
            if (parentOne.getWffTree().isImp() && parentTwo.getWffTree().isImp()) {
                WffTree antecedent = _wffTree.getChild(0);
                WffTree consequent = _wffTree.getChild(1);
                // Case 1: (X > Y), (Y > Z) => (X > Z)
                if (antecedent.stringEquals(parentOne.getWffTree().getChild(0)) &&
                    consequent.stringEquals(parentTwo.getWffTree().getChild(1))) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.HS, parentOne, parentTwo));
                    return true;
                }
                // Case 2: (Y > Z), (X > Y) => (X > Z)
                if (antecedent.stringEquals(parentTwo.getWffTree().getChild(0)) &&
                    consequent.stringEquals(parentOne.getWffTree().getChild(1))) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.HS, parentTwo, parentOne));
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidDisjunctiveSyllogism(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);

        // The condition is that one of the parents MUST be a disjunction and
        // the other must be the negation of one operand.
        if (parentOne.getWffTree().isOr() || parentTwo.getWffTree().isOr()) {
            // Case 1: parentOne is the OR we're checking against and parentTwo is the negated operand.
            NDWffTree orNode = parentOne.getWffTree().isOr() ? parentOne : parentTwo;
            NDWffTree othNode = parentOne.getWffTree().isOr() ? parentTwo : parentOne;
            if (orNode.getWffTree().getChild(0).stringEquals(BaseTruthTreeGenerator.getFlippedNode(othNode.getWffTree()))) {
                // Now check to see if _wffTree is equal to the other operand.
                if (_wffTree.stringEquals(orNode.getWffTree().getChild(1))) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.DS, parentOne, parentTwo));
                    return true;
                }
            } else if (orNode.getWffTree().getChild(1).stringEquals(BaseTruthTreeGenerator.getFlippedNode(othNode.getWffTree()))) {
                // Now check to see if _wffTree is equal to the other operand.
                if (_wffTree.stringEquals(orNode.getWffTree().getChild(0))) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.DS, parentOne, parentTwo));
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidDoubleNegationElimination(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        // The only condition is that the parent is equivalent to this node if the DN is removed.


        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidDoubleNegationIntroduction(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        // The only condition is that the parent is equivalent to the node is the DN is introduced.

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidBiconditionalElimination(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        // The wff must be a conjunction of implications.
        if (_wffTree.isAnd() && _wffTree.getChild(0).isImp() && _wffTree.getChild(1).isImp()) {
            // The single parent must be a biconditional.
            if (parentOne.getWffTree().isBicond()) {
                // Now, the two implications must be of op1 > op2 and op2 > op1.
                WffTree op1 = parentOne.getWffTree().getChild(0);
                WffTree op2 = parentOne.getWffTree().getChild(1);
                if (_wffTree.getChild(0).getChild(0).stringEquals(op1)
                 && _wffTree.getChild(0).getChild(1).stringEquals(op2)
                 && _wffTree.getChild(1).getChild(0).stringEquals(op2)
                 && _wffTree.getChild(1).getChild(1).stringEquals(op1)) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.BCB, parentOne));
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidBiconditionalIntroduction(WffTree _wffTree, int[] _parents) {
        NDWffTree parentOne = this.getPremise(_parents[0]);
        NDWffTree parentTwo = this.getPremise(_parents[1]);
        // The wff must be a biconditional and the two parents must be implications.
        // The BC must have its operands be the antecedent and consequent of the implications.
        if (_wffTree.isBicond()) {
            if (parentOne.getWffTree().isImp() && parentTwo.getWffTree().isImp()) {
                WffTree op1 = _wffTree.getChild(0);
                WffTree op2 = _wffTree.getChild(1);
                if (parentOne.getWffTree().getChild(0).stringEquals(op1)
                        && parentOne.getWffTree().getChild(1).stringEquals(op2)
                        && parentTwo.getWffTree().getChild(0).stringEquals(op2)
                        && parentTwo.getWffTree().getChild(1).stringEquals(op1)) {
                    this.addPremise(new NDWffTree(_wffTree, NDStep.BCI, parentOne, parentTwo));
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param _strs
     * @return
     */
    private int[] convertToIntArray(String[] _strs) {
        int[] nums = new int[_strs.length];
        for (int i = 0; i < _strs.length; i++) {
            // Check to see if the number is valid. Offset by 1.
            int idx = Integer.parseInt(_strs[i]) - 1;
            if (idx < 0 || idx >= this.premisesList.size()) {
                throw new IllegalArgumentException((idx + 1) + " is not a valid premise!");
            }
            nums[i] = idx;
        }
        return nums;
    }

    /**
     *
     */
    private void displayArgument() {
        for (int i = 0; i < this.premisesList.size(); i++) {
            System.out.println((i + 1) + ": " + this.premisesList.get(i));
        }
        System.out.println("Conclusion to prove: " + this.conclusionWff);
    }

    /**
     *
     * @param _ndWffTree
     */
    private void addPremise(NDWffTree _ndWffTree) {
        this.premisesList.add(_ndWffTree);
    }

    /**
     *
     */
    private void assignParentIndices() {
        for (NDWffTree premise : this.premisesList) {
            if (premise.getDerivedParentIndices().isEmpty()) {
                ArrayList<Integer> indices = new ArrayList<>();
                for (NDWffTree parent : premise.getDerivedParents()) {
                    indices.add(this.premisesList.indexOf(parent) + 1);
                }
                premise.setDerivedParentIndices(indices);
            }
        }
    }

    /**
     *
     * @return
     */
    private boolean findConclusion() {
        for (NDWffTree ndWffTree : this.premisesList) {
            if (ndWffTree.getWffTree().stringEquals(this.conclusionWff.getWffTree())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param _index
     * @return
     */
    private NDWffTree getPremise(int _index) {
        return this.premisesList.get(_index);
    }

    /**
     *
     * @param _step
     * @return
     */
    private NDStep getStep(String _step) {
        return NDStep.valueOf(_step);
    }
}
