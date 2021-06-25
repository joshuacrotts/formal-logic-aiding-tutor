package com.flat.algorithms;

import com.flat.algorithms.models.NDWffTree;
import com.flat.algorithms.models.ProofType;
import com.flat.algorithms.predicate.PredicateNaturalDeductionValidator;
import com.flat.algorithms.propositional.PropositionalNaturalDeductionValidator;
import com.flat.models.treenode.NegNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;

public class IndirectProofNaturalDeductionValidator implements NaturalDeductionAlgorithm {

    /**
     *
     */
    private final BaseNaturalDeductionValidator NATURAL_DEDUCTION_VALIDATOR;

    public IndirectProofNaturalDeductionValidator(ArrayList<WffTree> _args) {
        // The first thing we need to do is add the negated conclusion as a premise.
        NegNode negConclusion = new NegNode();
        negConclusion.addChild(_args.get(_args.size() - 1).getChild(0));

        // Now create a copy of the list so we don't modify the original.
        ArrayList<WffTree> premiseList = new ArrayList<>(_args.size());
        premiseList.addAll(_args);
        premiseList.add(premiseList.size() - 1, negConclusion);

        if (premiseList.get(0).isPropositionalWff()) {
            this.NATURAL_DEDUCTION_VALIDATOR = new PropositionalNaturalDeductionValidator(premiseList, ProofType.INDIRECT);
        } else {
            this.NATURAL_DEDUCTION_VALIDATOR = new PredicateNaturalDeductionValidator(premiseList, ProofType.INDIRECT);
        }
    }

    @Override
    public ArrayList<NDWffTree> getNaturalDeductionProof() {
        return NATURAL_DEDUCTION_VALIDATOR.getNaturalDeductionProof();
    }
}
