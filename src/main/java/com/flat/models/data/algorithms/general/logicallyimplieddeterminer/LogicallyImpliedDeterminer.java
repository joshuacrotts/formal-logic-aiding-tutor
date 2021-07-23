package com.flat.models.data.algorithms.general.logicallyimplieddeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyImpliedDeterminer extends Algorithm {

    public LogicallyImpliedDeterminer () {
        super(new KeyedText(LogicallyImpliedDeterminer.class, Algorithm.Keys.LABEL, "Logically implied determiner"),
                AlgorithmType.LOGICALLY_IMPLIED_DETERMINER
        );
    }

    public LogicallyImpliedDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}