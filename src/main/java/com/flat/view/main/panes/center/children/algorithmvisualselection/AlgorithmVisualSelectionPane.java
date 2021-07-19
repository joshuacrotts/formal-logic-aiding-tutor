package com.flat.view.main.panes.center.children.algorithmvisualselection;

import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree.ParseTreeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable.TruthTableButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree.TruthTreeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.AlgorithmResultPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionPane extends HBox {
    private Region emptyRegion = new Region();

    public AlgorithmVisualSelectionPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setEmptyRegionFx();
    }

    private void setThisFx () {
    super.getChildren().addAll(new TruthTreeButton(), new ParseTreeButton(), new TruthTableButton(), new AlgorithmResultPane());
    super.setAlignment(Pos.CENTER_LEFT);
    super.setSpacing(10);
    }

    private void setEmptyRegionFx () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
    }

}