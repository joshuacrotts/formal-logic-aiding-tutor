package com.flat.models.data.algorithms.propositional.randompropositionalformula;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class RandomPropositionalFormula extends Algorithm {

    public RandomPropositionalFormula () {
        super(new KeyedText(RandomPropositionalFormula.class, Algorithm.Keys.LABEL, "Random Propositional Formula"),
                AlgorithmType.RANDOM_PROPOSITIONAL_FORMULA
        );
    }

    public RandomPropositionalFormula (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}