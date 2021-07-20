package com.flat.view.main.panes.right;

import com.flat.view.action.ResizePane;
import com.flat.view.data.pane.PaneData;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainRight extends HBox {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.LEFT);

    public MainRight() {
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getRightProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getRightProperty().borderProperty());
        super.getChildren().add(this.resizePane.getParentPane());
    }

    // Getters for object's attributes.
    public ResizePane getResizePane () {
        return resizePane;
    }

}