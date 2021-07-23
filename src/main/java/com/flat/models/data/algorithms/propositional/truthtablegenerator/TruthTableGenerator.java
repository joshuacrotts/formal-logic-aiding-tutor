package com.flat.models.data.algorithms.propositional.truthtablegenerator;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class TruthTableGenerator extends Algorithm {

    public TruthTableGenerator () {
        super(new KeyedText(TruthTableGenerator.class, Algorithm.Keys.LABEL, "Truth Table Generator"),
                AlgorithmType.TRUTH_TABLE_GENERATOR
        );
    }

    public TruthTableGenerator (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}