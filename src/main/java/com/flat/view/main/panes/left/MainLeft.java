package com.flat.view.main.panes.left;

import com.flat.view.action.ResizePane;
import com.flat.view.data.pane.PaneData;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainLeft extends HBox {
    private Region emptyRegion = new Region();
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.RIGHT);

    public MainLeft() {
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setThisFx();
        this.setEmptyRegionFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getLeftProperty().borderProperty());
        super.getChildren().addAll(this.emptyRegion, this.resizePane.getParentPane());
    }

    private void setEmptyRegionFx () {
        HBox.setHgrow(this.emptyRegion, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public ResizePane getResizePane() {
        return resizePane;
    }

}