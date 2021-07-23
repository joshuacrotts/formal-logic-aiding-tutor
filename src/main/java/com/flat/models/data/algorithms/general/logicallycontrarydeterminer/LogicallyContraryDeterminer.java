package com.flat.models.data.algorithms.general.logicallycontrarydeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyContraryDeterminer extends Algorithm {

    public LogicallyContraryDeterminer () {
        super(new KeyedText(LogicallyContraryDeterminer.class, Algorithm.Keys.LABEL, "Logically Contrary Determiner"),
                AlgorithmType.LOGICALLY_CONTRARY_DETERMINER
        );
    }

    public LogicallyContraryDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}