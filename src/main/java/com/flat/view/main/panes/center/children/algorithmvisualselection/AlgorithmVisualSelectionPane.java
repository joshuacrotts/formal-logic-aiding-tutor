package com.flat.view.main.panes.center.children.algorithmvisualselection;

import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.ParseTreeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.TruthTableButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.TruthTreeButton;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionPane extends HBox {

    public AlgorithmVisualSelectionPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    super.getChildren().addAll(new TruthTreeButton(), new ParseTreeButton(), new TruthTableButton());
    super.setAlignment(Pos.CENTER_LEFT);
    super.setSpacing(10);
    }

}