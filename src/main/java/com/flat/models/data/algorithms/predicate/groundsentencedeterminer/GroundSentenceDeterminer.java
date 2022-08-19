package com.flat.models.data.algorithms.predicate.groundsentencedeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class GroundSentenceDeterminer extends Algorithm {

    public GroundSentenceDeterminer () {
        super(new KeyedText(GroundSentenceDeterminer.class, Keys.LABEL, "Ground Sentence Determiner"),
                AlgorithmType.GROUND_SENTENCE_DETERMINER
        );
    }

    public GroundSentenceDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}