package com.flat.models.data.algorithms.general.semanticentailmentdeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class SemanticEntailmentDeterminer extends Algorithm {

    public SemanticEntailmentDeterminer () {
        super(new KeyedText(SemanticEntailmentDeterminer.class, Keys.LABEL, "Semantic Entailment Determiner"),
                AlgorithmType.SEMANTIC_ENTAILMENT_DETERMINER
        );
    }

    public SemanticEntailmentDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}