package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children;

import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.predicatendv.PredicateNDVTimeoutPane;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.predicatetruthtree.PredicateTruthTreeTimeoutPane;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.propositionalndv.PropositionalNDVTimeoutPane;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.propositionaltruthtree.PropositionalTruthTreeTimeoutPane;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.truthtablegenerator.TruthTableGeneratorTimeoutPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TimeoutFieldsPane extends VBox {
    private PredicateNDVTimeoutPane predicateNDV = new PredicateNDVTimeoutPane();
    private PredicateTruthTreeTimeoutPane predicateTruthTree = new PredicateTruthTreeTimeoutPane();
    private PropositionalNDVTimeoutPane propositionalNDV = new PropositionalNDVTimeoutPane();
    private PropositionalTruthTreeTimeoutPane propositionalTruthTree = new PropositionalTruthTreeTimeoutPane();
    private TruthTableGeneratorTimeoutPane truthTable = new TruthTableGeneratorTimeoutPane();

    public TimeoutFieldsPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.getChildren().addAll(this.predicateNDV, this.predicateTruthTree, this.propositionalNDV,
                this.propositionalTruthTree, this.truthTable);
        super.setSpacing(10);
        super.setPadding(new Insets(10));
        super.setMaxWidth(500);
        super.getStyleClass().add("timeoutFieldsPane");
    }

}