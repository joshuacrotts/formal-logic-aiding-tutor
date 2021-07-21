package com.flat.view.main.panes.left;

import com.flat.view.action.ResizePane;
import com.flat.view.data.fx.pane.PaneData;
import com.flat.view.main.panes.left.children.MainLeftWrapperPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainLeft extends HBox {
    private MainLeftWrapperPane vBox = new MainLeftWrapperPane();
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.RIGHT);

    public MainLeft() {
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setThisFx();
        this.setVBoxFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getLeftProperty().borderProperty());
        super.getChildren().addAll(this.vBox, this.resizePane.getParentPane());
    }

    private void setVBoxFx () {
        HBox.setHgrow(this.vBox, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public ResizePane getResizePane() {
        return resizePane;
    }

}