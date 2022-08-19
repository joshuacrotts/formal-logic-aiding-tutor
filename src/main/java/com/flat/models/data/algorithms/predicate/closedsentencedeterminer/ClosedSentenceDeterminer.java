package com.flat.models.data.algorithms.predicate.closedsentencedeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class ClosedSentenceDeterminer extends Algorithm {

    public ClosedSentenceDeterminer () {
        super(new KeyedText(ClosedSentenceDeterminer.class, Keys.LABEL, "Closed Sentence Determiner"),
                AlgorithmType.CLOSED_SENTENCE_DETERMINER
        );
    }

    public ClosedSentenceDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}