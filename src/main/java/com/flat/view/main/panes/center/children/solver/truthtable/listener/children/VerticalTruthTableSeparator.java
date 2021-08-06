package com.flat.view.main.panes.center.children.solver.truthtable.listener.children;

import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class VerticalTruthTableSeparator extends Separator {

    public VerticalTruthTableSeparator () {
        super(Orientation.VERTICAL);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        VBox.setVgrow(this, Priority.ALWAYS);
    }

}