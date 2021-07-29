package com.flat.models.data.algorithms.propositional.propositionalnaturaldeduction;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalNaturalDeduction extends Algorithm {

    public PropositionalNaturalDeduction () {
        super(
                new KeyedText(PropositionalNaturalDeduction.class, Algorithm.Keys.LABEL, "Propositional Natural Deduction"),
                AlgorithmType.PROPOSITIONAL_NATURAL_DEDUCTION
        );
    }

    public PropositionalNaturalDeduction (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}