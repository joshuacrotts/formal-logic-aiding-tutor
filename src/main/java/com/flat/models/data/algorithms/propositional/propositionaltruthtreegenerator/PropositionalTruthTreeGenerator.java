package com.flat.models.data.algorithms.propositional.propositionaltruthtreegenerator;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class PropositionalTruthTreeGenerator extends Algorithm {

    public PropositionalTruthTreeGenerator () {
        super(new KeyedText(PropositionalTruthTreeGenerator.class, Algorithm.Keys.LABEL, "Propositional Truth tree Generator"),
                AlgorithmType.PROPOSITIONAL_TRUTH_TREE_GENERATOR
        );
    }

    public PropositionalTruthTreeGenerator (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}