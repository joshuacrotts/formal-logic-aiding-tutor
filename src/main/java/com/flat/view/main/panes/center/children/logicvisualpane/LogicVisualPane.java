package com.flat.view.main.panes.center.children.logicvisualpane;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author christopherbrantley
 */
public class LogicVisualPane extends ScrollPane {

    public LogicVisualPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setPannable(true);
        VBox.setVgrow(this, Priority.ALWAYS);
        super.setVbarPolicy(ScrollBarPolicy.NEVER);
        super.setHbarPolicy(ScrollBarPolicy.NEVER);
        super.setFitToHeight(true);
        super.setFitToWidth(true);
    }

    public final void updateContent (Pane _pane) {
        this.setContent(null);
        this.setContent(_pane);
    }

    public final void centerViewPort () {
        this.centerViewPortHorizontally();
        this.centerViewPortVertically();
    }

    public final void centerViewPortHorizontally () {
        super.setHvalue(super.getHmax() / 2);
    }

    public final void centerViewPortVertically () {
     super.setVvalue(super.getVmax() / 2);
    }

}