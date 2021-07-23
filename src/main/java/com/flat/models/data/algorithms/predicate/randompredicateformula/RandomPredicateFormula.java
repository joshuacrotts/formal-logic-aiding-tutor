package com.flat.models.data.algorithms.predicate.randompredicateformula;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class RandomPredicateFormula extends Algorithm {

    public RandomPredicateFormula () {
        super(new KeyedText(RandomPredicateFormula.class, Algorithm.Keys.LABEL, "Random Predicate Formula"),
                AlgorithmType.RANDOM_PREDICATE_FORMULA
        );
    }

    public RandomPredicateFormula (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}