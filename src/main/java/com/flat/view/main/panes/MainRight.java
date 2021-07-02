package com.flat.view.main.panes;

import com.flat.view.action.ResizePane;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainRight extends Pane {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.LEFT);

    public MainRight() {
        super.backgroundProperty().bind(PaneData.getRightProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getRightProperty().borderProperty());
        super.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    public void setResizePaneFx() {
        this.resizePane.getParentPane().setLayoutX(0);
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