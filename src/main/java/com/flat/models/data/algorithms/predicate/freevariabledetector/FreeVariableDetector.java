package com.flat.models.data.algorithms.predicate.freevariabledetector;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class FreeVariableDetector extends Algorithm {

    public FreeVariableDetector () {
        super(new KeyedText(FreeVariableDetector.class, Keys.LABEL, "Free Variable Detector"),
                AlgorithmType.FREE_VARIABLE_DETECTOR
        );
    }

    public FreeVariableDetector (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}