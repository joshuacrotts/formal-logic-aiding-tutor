package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatendv.PredicateNDVTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.predicatetruthtree.PredicateTruthTreeTimeoutPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.propositionalndv.PropositionalNDVTimeoutPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class TimeoutPane extends VBox {
    private PredicateNDVTimeoutPane predicateNDVTimeoutPane = new PredicateNDVTimeoutPane();
    private PredicateTruthTreeTimeoutPane predicateTruthTreeTimeoutPane = new PredicateTruthTreeTimeoutPane();
    private PropositionalNDVTimeoutPane propositionalNDVTimeoutPane = new PropositionalNDVTimeoutPane();

    public TimeoutPane () {
        super.getChildren().addAll(this.predicateNDVTimeoutPane, this.predicateTruthTreeTimeoutPane,
                this.propositionalNDVTimeoutPane);
        super.setAlignment(Pos.CENTER);
    }

}