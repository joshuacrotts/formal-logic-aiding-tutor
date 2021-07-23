package com.flat.view.data.fx.algorithms;

import com.flat.controller.Controller;
import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.view.data.fx.algorithms.listener.AvailableAlgorithmsListener;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AvailableAlgorithms {
    private final ObservableList generalAlgorithms = FXCollections.observableArrayList();
    private final ObservableList propositionalAlgorithms = FXCollections.observableArrayList();
    private final ObservableList predicateAlgorithms = FXCollections.observableArrayList();

    public AvailableAlgorithms () {
        Controller.DATA_BUS.addListener(new AvailableAlgorithmsListener(this));
    }

    public void clearAlgorithms () {
        this.generalAlgorithms.clear();
        this.propositionalAlgorithms.clear();
        this.predicateAlgorithms.clear();
    }

    // Getters for object's attributes.
    public  ObservableList getGeneralAlgorithms () {
        return this.generalAlgorithms;
    }

    public  ObservableList getPropositionalAlgorithms () {
        return this.propositionalAlgorithms;
    }

    public  ObservableList getPredicateAlgorithms () {
        return this.predicateAlgorithms;
    }

    // Add methods for object' attributes.
    public void addGeneralAlgorithms (ArrayList <Algorithm> _algorithms) {
        this.generalAlgorithms.addAll(_algorithms);
    }

    public void addPropositionalAlgorithms (ArrayList <Algorithm> _algorithms) {
        this.propositionalAlgorithms.addAll(_algorithms);
    }

    public void addPredicateAlgorithms (ArrayList <Algorithm> _algorithms) {
        this.predicateAlgorithms.addAll(_algorithms);
    }

}