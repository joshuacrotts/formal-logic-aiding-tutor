package com.flat.models.algorithms.bus.updates;

import com.flat.models.algorithms.attributes.ApplicableAlgorithms;
import com.flat.tools.buses.databus.components.Update;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplicableAlgorithmsUpdate extends Update {
    private ApplicableAlgorithms algorithms = new ApplicableAlgorithms();

    public ApplicableAlgorithmsUpdate (ApplicableAlgorithms _algorithms) {
        super(Type.APPLICABLE_ALGORITHMS);
        this.algorithms = _algorithms;
    }

    // Getters for object's attributes.
    public ApplicableAlgorithms getAlgorithms() {
        return algorithms;
    }

    // Setters for object's attributes.
    public void setAlgorithms(ApplicableAlgorithms algorithms) {
        this.algorithms = algorithms;
    }

}