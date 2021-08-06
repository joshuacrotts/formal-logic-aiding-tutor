package com.flat.view.main.panes.center.children.solver.truthtable.listener.children;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class HorizontalTruthTableSeparator extends Separator {

    public HorizontalTruthTableSeparator () {
        super(Orientation.HORIZONTAL);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHalignment(this, HPos.CENTER);
    }

}