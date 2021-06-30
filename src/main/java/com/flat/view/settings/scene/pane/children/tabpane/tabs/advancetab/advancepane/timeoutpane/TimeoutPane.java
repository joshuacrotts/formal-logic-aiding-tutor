package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.PredicateNDVTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.PredicateTruthTreeTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.PropositionalNDVTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionaltruthtree.PropositionalTruthTreeTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.truthtablegenerator.TruthTableGeneratorTimeoutPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class TimeoutPane extends VBox {
    private PredicateNDVTimeoutPane predicateNDV = new PredicateNDVTimeoutPane();
    private PredicateTruthTreeTimeoutPane predicateTruthTree = new PredicateTruthTreeTimeoutPane();
    private PropositionalNDVTimeoutPane propositionalNDV = new PropositionalNDVTimeoutPane();
    private PropositionalTruthTreeTimeoutPane propositionalTruthTree = new PropositionalTruthTreeTimeoutPane();
    private TruthTableGeneratorTimeoutPane truthTable = new TruthTableGeneratorTimeoutPane();

    public TimeoutPane () {
        super.getChildren().addAll(this.predicateNDV, this.predicateTruthTree,
                this.propositionalNDV, this.propositionalTruthTree,
                this.truthTable);
        super.setAlignment(Pos.CENTER);
    }

}