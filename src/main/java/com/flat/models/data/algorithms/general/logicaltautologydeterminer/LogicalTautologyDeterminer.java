package com.flat.models.data.algorithms.general.logicaltautologydeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicalTautologyDeterminer extends Algorithm {

    public LogicalTautologyDeterminer () {
        super(new KeyedText(LogicalTautologyDeterminer.class, Keys.LABEL, "Logical Tautology Determiner"),
                AlgorithmType.LOGICAL_TAUTOLOGY_DETERMINER
        );
    }

    public LogicalTautologyDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}