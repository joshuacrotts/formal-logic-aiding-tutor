package com.flat.models.data.algorithms.predicate.opensentencedeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class OpenSentenceDeterminer extends Algorithm {

    public OpenSentenceDeterminer () {
        super(new KeyedText(OpenSentenceDeterminer.class, Keys.LABEL, "Open Sentence Determiner"),
                AlgorithmType.OPEN_SENTENCE_DETERMINER
        );
    }

    public OpenSentenceDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}