package com.flat.view.main.panes.right;

import com.flat.view.action.ResizePane;
import com.flat.view.data.fx.pane.PaneData;
import com.flat.view.main.panes.right.children.RightVBoxWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainRight extends HBox {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.LEFT);
    private RightVBoxWrapper vboxWrapper = new RightVBoxWrapper();
    public static SimpleDoubleProperty WRAPPING_WIDTH = new SimpleDoubleProperty(0);

    public MainRight() {
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx () {
        this.setThisFx();
        this.setVBoxWrapperFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getRightProperty().backgroundProperty());
        super.getChildren().addAll(this.resizePane.getParentPane(), this.vboxWrapper);
        this.setWidthProperty();
    }

    private void setWidthProperty () {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            MainRight.WRAPPING_WIDTH.set(newVal.doubleValue() - this.resizePane.getParentPane().getWidth() - 30);
        });
    }

    private void setVBoxWrapperFx () {
        HBox.setHgrow(this.vboxWrapper, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public ResizePane getResizePane () {
        return resizePane;
    }

}