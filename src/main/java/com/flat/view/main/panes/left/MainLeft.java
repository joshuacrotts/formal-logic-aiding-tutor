package com.flat.view.main.panes.left;

import com.flat.view.action.ResizePane;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainLeft extends Pane {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.RIGHT);

    public MainLeft() {
        super.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getLeftProperty().borderProperty());
        super.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    private void setResizePaneFx() {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setLayoutX(newVal.doubleValue() - this.resizePane.getParentPane().getMaxWidth());
        });
        super.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setMinHeight(newVal.doubleValue());
            this.resizePane.getParentPane().setMaxHeight(newVal.doubleValue());
        });
    }

    // Getters for object's attributes.
    public ResizePane getResizePane() {
        return resizePane;
    }

}