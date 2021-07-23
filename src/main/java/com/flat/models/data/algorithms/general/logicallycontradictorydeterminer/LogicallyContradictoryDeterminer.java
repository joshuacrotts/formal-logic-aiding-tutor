package com.flat.models.data.algorithms.general.logicallycontradictorydeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyContradictoryDeterminer extends Algorithm {

    public LogicallyContradictoryDeterminer () {
        super(new KeyedText(LogicallyContradictoryDeterminer.class, Algorithm.Keys.LABEL, "Logically Contradictory Determiner"),
                AlgorithmType.LOGICALLY_CONTRADICTORY_DETERMINER
        );
    }

    public LogicallyContradictoryDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}