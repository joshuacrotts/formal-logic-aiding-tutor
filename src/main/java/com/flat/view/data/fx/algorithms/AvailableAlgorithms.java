package com.flat.view.data.fx.algorithms;

import com.flat.models.json.algorithm.JsonAlgorithm;
import java.util.ArrayList;
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

    public static void clearAlgorithms () {
        generalAlgorithms.clear();
        propositionalAlgorithms.clear();
        predicateAlgorithms.clear();
    }

    public static void addGeneralAlgorithms (ArrayList <JsonAlgorithm> _jsonAlgorithms) {
        generalAlgorithms.addAll(_jsonAlgorithms);
    }

    public static void addPropositionalAlgorithms (ArrayList <JsonAlgorithm> _jsonAlgorithms) {
        propositionalAlgorithms.addAll(_jsonAlgorithms);
    }

    public static void addPredicateAlgorithms (ArrayList <JsonAlgorithm> _jsonAlgorithms) {
        predicateAlgorithms.addAll(_jsonAlgorithms);
    }

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