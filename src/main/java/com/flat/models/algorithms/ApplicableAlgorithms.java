package com.flat.models.algorithms;

import com.flat.models.json.algorithm.JsonAlgorithm;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplicableAlgorithms {
    private ArrayList <JsonAlgorithm> general = new ArrayList();
    private ArrayList <JsonAlgorithm> predicate = new ArrayList();
    private ArrayList <JsonAlgorithm> propositional = new ArrayList();

    public ApplicableAlgorithms () {
    }

    public void clearAllAlgorithms () {
        general.clear();
        predicate.clear();
        propositional.clear();
    }

    // Getters for object's attributes.
    public ArrayList<JsonAlgorithm> getGeneral() {
        return general;
    }

    public ArrayList<JsonAlgorithm> getPredicate() {
        return predicate;
    }

    public ArrayList<JsonAlgorithm> getPropositional() {
        return propositional;
    }

    // Setters for object's attributes.
    public void setGeneral(ArrayList<JsonAlgorithm> general) {
        this.general = general;
    }

    public void setPredicate(ArrayList<JsonAlgorithm> predicate) {
        this.predicate = predicate;
    }

    public void setPropositional(ArrayList<JsonAlgorithm> propositional) {
        this.propositional = propositional;
    }

}