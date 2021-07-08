package com.flat.input.tests;

import com.flat.algorithms.NaturalDeductionProofVerifier;
import com.flat.input.FLATParserAdapter;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Scanner;

public class NaturalDeductionProofVerifierTest {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        ArrayList<WffTree> initArgsWffTrees = FLATParserAdapter.getAbstractSyntaxTree(stdin.nextLine());
        NaturalDeductionProofVerifier verifier = new NaturalDeductionProofVerifier(initArgsWffTrees);
        verifier.proveNaturalDeductionStdin();
    }
}
