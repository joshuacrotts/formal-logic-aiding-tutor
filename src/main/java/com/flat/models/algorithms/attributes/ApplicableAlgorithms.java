package com.flat.models.algorithms.attributes;

import com.flat.models.data.algorithms.base.Algorithm;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplicableAlgorithms {
    private ArrayList <Algorithm> general = new ArrayList();
    private ArrayList <Algorithm> predicate = new ArrayList();
    private ArrayList <Algorithm> propositional = new ArrayList();

    public ApplicableAlgorithms () {
    }

    public void clearAllAlgorithms () {
        general.clear();
        predicate.clear();
        propositional.clear();
    }

    // Getters for object's attributes.
    public ArrayList <Algorithm> getGeneral() {
        return general;
    }

    public ArrayList <Algorithm> getPredicate() {
        return predicate;
    }

    public ArrayList <Algorithm> getPropositional() {
        return propositional;
    }

    // Setters for object's attributes.
    public void setGeneral(ArrayList <Algorithm> general) {
        this.general = general;
    }

    public void setPredicate(ArrayList <Algorithm> predicate) {
        this.predicate = predicate;
    }

    public void setPropositional(ArrayList <Algorithm> propositional) {
        this.propositional = propositional;
    }

}