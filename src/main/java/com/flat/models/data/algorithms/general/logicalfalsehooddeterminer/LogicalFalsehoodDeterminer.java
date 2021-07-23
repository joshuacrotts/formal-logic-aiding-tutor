package com.flat.models.data.algorithms.general.logicalfalsehooddeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicalFalsehoodDeterminer extends Algorithm {

    public LogicalFalsehoodDeterminer () {
        super(new KeyedText(LogicalFalsehoodDeterminer.class, Algorithm.Keys.LABEL, "Logical Falsehood Determiner"),
                AlgorithmType.LOGICAL_FALSEHOOD_DETERMINER
        );
    }

    public LogicalFalsehoodDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}