package com.flat.view.main.panes.center.children.algorithmselection;

import com.flat.controller.Controller;
import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.GeneralComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PredicateComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PropositionalComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.listener.AlgorithmSelectionPaneListener;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
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
    private Algorithm selectedAlgorithm = null;

    public AlgorithmSelectionPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new AlgorithmSelectionPaneListener(this));
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
        super.setPadding(new Insets(10));
    }

    private void setGeneralComboFx () {
        this.setOnComboSelection(this.generalCombo);
        this.setOnGeneralWidth();
    }

    private void setOnGeneralWidth () {
        this.generalCombo.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.setComboBoxWidth(getMaxComboWidth());
        });
    }

    private void setPredicateComboFx () {
        this.setOnComboSelection(this.predicateCombo);
        this.setOnPredicateWidth();
    }

    private void setOnPredicateWidth () {
        this.predicateCombo.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.setComboBoxWidth(getMaxComboWidth());
        });
    }

    private void setPropositionalComboFx () {
        this.setOnComboSelection(this.propositionalCombo);
        this.setOnPropositionalWidth();
    }

    private void setOnPropositionalWidth () {
        this.propositionalCombo.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.setComboBoxWidth(getMaxComboWidth());
        });
    }

    private void setOnComboSelection (ComboBox _comboBox) {
        _comboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null)
                return;
            this.selectedAlgorithm = (Algorithm)_comboBox.getValue();
        });
    }

    private double getMaxComboWidth () {
        return Math.max(this.generalCombo.getWidth(), Math.max(this.predicateCombo.getWidth(), this.propositionalCombo.getWidth()));
    }

    private void setComboBoxWidth (double _maxWidth) {
        this.generalCombo.setPrefWidth(_maxWidth);
        this.predicateCombo.setPrefWidth(_maxWidth);
        this.propositionalCombo.setPrefWidth(_maxWidth);
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

    public Algorithm getSelectedAlgorithm() {
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

    public void setSelectedAlgorithm(Algorithm selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

}