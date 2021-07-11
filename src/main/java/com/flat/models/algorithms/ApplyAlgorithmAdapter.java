package com.flat.models.algorithms;

import com.flat.models.json.algorithm.JsonAlgorithms;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithmAdapter extends ApplyAlgorithm {

    public ApplyAlgorithmAdapter (JsonAlgorithms _algorithms) {
        super.setJsonAlgorithms(_algorithms);
    }

}