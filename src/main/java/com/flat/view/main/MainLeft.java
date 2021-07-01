package com.flat.view.main;

import com.flat.view.action.ResizePane;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainLeft {
    private final ResizePane resizePane;
    private Pane parentPane = new Pane();

    public MainLeft() {
        this.parentPane.setStyle("-fx-background-color: yellow");
        this.resizePane = new ResizePane(this.parentPane, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.RIGHT);
        this.parentPane.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
        this.parentPane.borderProperty();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    private void setResizePaneFx() {
        this.parentPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setLayoutX(newVal.doubleValue() - this.resizePane.getParentPane().getMaxWidth());
        });
        this.parentPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setMinHeight(newVal.doubleValue());
            this.resizePane.getParentPane().setMaxHeight(newVal.doubleValue());
        });
    }

    // Getters for object's attributes.
    public Pane getParentPane() {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane(Pane parentPane) {
        this.parentPane = parentPane;
    }

}