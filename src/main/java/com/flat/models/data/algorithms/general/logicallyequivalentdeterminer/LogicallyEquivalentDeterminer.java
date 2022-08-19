package com.flat.models.data.algorithms.general.logicallyequivalentdeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class LogicallyEquivalentDeterminer extends Algorithm {

    public LogicallyEquivalentDeterminer () {
        super(new KeyedText(LogicallyEquivalentDeterminer.class, Keys.LABEL, "Logically Equivalent Determiner"),
                AlgorithmType.LOGICALLY_EQUIVALENT_DETERMINER
        );
    }

    public LogicallyEquivalentDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}