package com.flat.view.main.panes.center.children.algorithmselection;

import com.flat.controller.Controller;
import com.flat.models.json.algorithm.JsonAlgorithm;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.GeneralComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PredicateComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PropositionalComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.listener.AlgorithmSelectionPaneListener;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmSelectionPane extends HBox {
    private GeneralComboBox generalCombo = new GeneralComboBox();
    private PredicateComboBox predicateCombo = new PredicateComboBox();
    private PropositionalComboBox propositionalCombo = new PropositionalComboBox();
    private List <ComboBox> comboBoxes = Arrays.asList(generalCombo, predicateCombo, propositionalCombo);
    private JsonAlgorithm selectedAlgorithm = null;

    public AlgorithmSelectionPane () {
        this.initializeFx();
        Controller.getEVENT_BUS().addListener(new AlgorithmSelectionPaneListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setGeneralComboFx();
        this.setPredicateComboFx();
        this.setPropositionalComboFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.generalCombo, this.predicateCombo, this.propositionalCombo);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
    }

    private void setGeneralComboFx () {
        this.setOnComboSelection(this.generalCombo);
    }

    private void setPredicateComboFx () {
        this.setOnComboSelection(this.predicateCombo);
    }

    private void setPropositionalComboFx () {
        this.setOnComboSelection(this.propositionalCombo);
    }

    private void setOnComboSelection (ComboBox _comboBox) {
        _comboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null)
                return;
            this.selectedAlgorithm = (JsonAlgorithm)_comboBox.getValue();
            this.comboBoxes.forEach(comboBox -> {
                if (!_comboBox.equals(comboBox))
                    comboBox.valueProperty().setValue(null);
            });
        });
    }

    // Getters for object's attributes.
    public GeneralComboBox getGeneralCombo() {
        return generalCombo;
    }

    public PredicateComboBox getPredicateCombo() {
        return predicateCombo;
    }

    public PropositionalComboBox getPropositionalCombo() {
        return propositionalCombo;
    }

    public List<ComboBox> getComboBoxes() {
        return comboBoxes;
    }

    public JsonAlgorithm getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    // Setters for object's attributes.
    public void setGeneralCombo(GeneralComboBox generalCombo) {
        this.generalCombo = generalCombo;
    }

    public void setPredicateCombo(PredicateComboBox predicateCombo) {
        this.predicateCombo = predicateCombo;
    }

    public void setPropositionalCombo(PropositionalComboBox propositionalCombo) {
        this.propositionalCombo = propositionalCombo;
    }

    public void setComboBoxes(List<ComboBox> comboBoxes) {
        this.comboBoxes = comboBoxes;
    }

    public void setSelectedAlgorithm(JsonAlgorithm selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

}