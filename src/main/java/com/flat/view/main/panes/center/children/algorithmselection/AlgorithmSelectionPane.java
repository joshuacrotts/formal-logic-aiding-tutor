package com.flat.view.main.panes.center.children.algorithmselection;

import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.GeneralComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PredicateComboBox;
import com.flat.view.main.panes.center.children.algorithmselection.children.comboboxes.PropositionalComboBox;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmSelectionPane extends HBox {
    private GeneralComboBox generalCombo = new GeneralComboBox();
    private PredicateComboBox predicateCombo = new PredicateComboBox();
    private PropositionalComboBox propositionalCombo = new PropositionalComboBox();

    public AlgorithmSelectionPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.generalCombo, this.predicateCombo, this.propositionalCombo);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
    }

}