package com.flat.models.data.algorithms.predicate.vacuousquantifierdetector;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class VacuousQuantifierDetector extends Algorithm {

    public VacuousQuantifierDetector () {
        super(new KeyedText(VacuousQuantifierDetector.class, Algorithm.Keys.LABEL, "Vacuous Quantifier Detector"),
                AlgorithmType.VACUOUS_QUANTIFIER_DETECTOR
        );
    }

    public VacuousQuantifierDetector (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}