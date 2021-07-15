package com.flat.view.main.panes.center.logicvisualpane;

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
        this.onThisContentProperty();
    }

    private void setThisFx () {
        super.setPannable(true);
        VBox.setVgrow(this, Priority.ALWAYS);
    }

    private void onThisContentProperty () {
        super.contentProperty().addListener(listener -> {
            ((Pane)super.getContent()).minWidthProperty().bind(super.widthProperty());
            ((Pane)super.getContent()).minHeightProperty().bind(super.heightProperty());
        });
    }

}