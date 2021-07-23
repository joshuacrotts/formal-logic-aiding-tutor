package com.flat.models.data.algorithms.general.logicallycontingentdeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyContingentDeterminer extends Algorithm {

    public LogicallyContingentDeterminer () {
        super(new KeyedText(LogicallyContingentDeterminer.class, Algorithm.Keys.LABEL, "Logically Contingent Determiner"),
                AlgorithmType.LOGICALLY_CONTINGENT_DETERMINER
        );
    }

    public LogicallyContingentDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}