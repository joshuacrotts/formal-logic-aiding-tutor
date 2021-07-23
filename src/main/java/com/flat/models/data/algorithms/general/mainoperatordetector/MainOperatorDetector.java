package com.flat.models.data.algorithms.general.mainoperatordetector;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class MainOperatorDetector extends Algorithm {

    public MainOperatorDetector () {
        super(new KeyedText(MainOperatorDetector.class, Algorithm.Keys.LABEL, "Main Operator Detector"),
                AlgorithmType.MAIN_OPERATOR_DETECTOR
        );
    }

    public MainOperatorDetector (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}