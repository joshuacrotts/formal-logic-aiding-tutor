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
public class NaturalDeductionProofVerifier {

    /**
     *
     */
    protected final ArrayList<WffTree> originalWffTreeList;

    /**
     *
     */
    protected final ArrayList<NDWffTree> originalPremisesList;

    /**
     *
     */
    protected final ArrayList<NDWffTree> premisesList;

    /**
     *
     */
    protected final NDWffTree conclusionWff;

    public NaturalDeductionProofVerifier(ArrayList<WffTree> _wffTreeList) {
        this.originalWffTreeList = _wffTreeList;
        this.premisesList = new ArrayList<>();
        this.originalPremisesList = new ArrayList<>();
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
     *
     */
    public void proveNaturalDeductionStdin() {
        Scanner stdin = new Scanner(System.in);
        while (true) {
            this.displayArgument();
            System.out.println("Enter next premise in the format: \"WFF, STEP; N,N0,...\"");
            String nextArg = stdin.nextLine().replaceAll("\\s+", "");
            String wff = nextArg.substring(0, nextArg.indexOf(","));
            String step = nextArg.substring(nextArg.indexOf(",") + 1, nextArg.indexOf(";"));
            String[] nums = nextArg.substring(nextArg.indexOf(";") + 1).split(",");
            System.out.println("Wff: " + wff + ", step: " + this.getStep(step) + ", nums: " + Arrays.toString(nums));
            ArrayList<WffTree> wffTreeList = FLATParserAdapter.getAbstractSyntaxTree(wff);
            this.addPremise(new NDWffTree(wffTreeList.get(0), NDFlag.ACTIVE, NDStep.P));
        }
    }

    private boolean isValidStep(WffTree _wffTree, NDStep _step, int[] _parents) {
        if (_step == NDStep.MP) {

        }

        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidModusPonens(WffTree _wffTree, int[] _parents) {
        if (_parents.length != 2) { return false; }
        return false;
    }

    /**
     *
     * @param _wffTree
     * @param _parents
     * @return
     */
    private boolean isValidModusTollens(WffTree _wffTree, int[] _parents) {
        if (_parents.length != 2) { return false; }
        return false;
    }

    /**
     *
     * @param _step
     * @return
     */
    private NDStep getStep(String _step) {
        return NDStep.valueOf(_step);
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
     * @param _index
     * @return
     */
    private NDWffTree getPremise(int _index) {
        return this.premisesList.get(_index);
    }

    /**
     *
     * @return
     */
    private boolean findConclusion() {
        for (NDWffTree ndWffTree : this.premisesList) {
            if (ndWffTree.getWffTree().stringEquals(this.conclusionWff.getWffTree())) {
                this.conclusionWff.setActive(true);
                this.conclusionWff.setDerivedParents(ndWffTree.getDerivedParents());
                this.conclusionWff.setDerivationStep(ndWffTree.getDerivationStep());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        ArrayList<WffTree> initArgsWffTrees = FLATParserAdapter.getAbstractSyntaxTree(stdin.nextLine());
        NaturalDeductionProofVerifier verifier = new NaturalDeductionProofVerifier(initArgsWffTrees);
        verifier.proveNaturalDeductionStdin();
    }
}
