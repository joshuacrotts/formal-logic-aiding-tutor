package com.flat.models.data.algorithms.predicate.predicatetruthtreegenerator;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class PredicateTruthTreeGenerator extends Algorithm {

    public PredicateTruthTreeGenerator () {
        super(new KeyedText(PredicateTruthTreeGenerator.class, Keys.LABEL, "Predicate Truth Tree Generator"),
                AlgorithmType.PREDICATE_TRUTH_TREE_GENERATOR
        );
    }

    public PredicateTruthTreeGenerator (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}