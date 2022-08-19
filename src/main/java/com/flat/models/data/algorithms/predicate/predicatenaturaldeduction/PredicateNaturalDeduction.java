package com.flat.models.data.algorithms.predicate.predicatenaturaldeduction;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PredicateNaturalDeduction extends Algorithm {

    public PredicateNaturalDeduction () {
        super(
                new KeyedText(PredicateNaturalDeduction.class, Keys.LABEL, "Predicate Natural Deduction"),
                AlgorithmType.PREDICATE_NATURAL_DEDUCTION
        );
    }

    public PredicateNaturalDeduction (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}