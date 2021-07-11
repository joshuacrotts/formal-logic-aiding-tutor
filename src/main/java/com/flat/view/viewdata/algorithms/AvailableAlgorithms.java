package com.flat.view.viewdata.algorithms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AvailableAlgorithms {
    private final static ObservableList generalAlgorithms = FXCollections.observableArrayList();
    private final static ObservableList propositionalAlgorithms = FXCollections.observableArrayList();
    private final static ObservableList predicateAlgorithms = FXCollections.observableArrayList();

    // Getters for object's attributes.
    public static ObservableList getGeneralAlgorithms() {
        return generalAlgorithms;
    }

    public static ObservableList getPropositionalAlgorithms() {
        return propositionalAlgorithms;
    }

    public static ObservableList getPredicateAlgorithms() {
        return predicateAlgorithms;
    }

}