package com.flat.models.data.algorithms.general.logicallyconsistentdeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyConsistentDeterminer extends Algorithm {

    public LogicallyConsistentDeterminer () {
        super(new KeyedText(LogicallyConsistentDeterminer.class, Keys.LABEL, "Logically Consistent Determiner"),
                AlgorithmType.LOGICALLY_CONSISTENT_DETERMINER
        );
    }

    public LogicallyConsistentDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}