package com.flat.models.data.algorithms.general.argumenttruthtreevalidator;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class ArgumentTruthTreeValidator extends Algorithm {

    public ArgumentTruthTreeValidator () {
        super(new KeyedText(ArgumentTruthTreeValidator.class, Algorithm.Keys.LABEL, "Argument Truth Tree Validator" ),
                AlgorithmType.ARGUMENT_TRUTH_TREE_VALIDATOR
        );
    }

    public ArgumentTruthTreeValidator (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}