package com.flat.models.data.algorithms.predicate.boundvariabledetector;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class BoundVariableDetector extends Algorithm {

    public BoundVariableDetector () {
        super(new KeyedText(BoundVariableDetector.class, Algorithm.Keys.LABEL, "Bound Variable Detector"),
                AlgorithmType.BOUND_VARIABLE_DETECTOR
        );
    }

    public BoundVariableDetector (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}