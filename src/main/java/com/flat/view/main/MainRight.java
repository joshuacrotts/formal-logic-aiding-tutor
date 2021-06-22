package com.flat.view.main;

import com.flat.view.Action.ResizePane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainRight {
    private Pane parentPane = new Pane();
    private ResizePane resizePane;

    public MainRight () {
        this.parentPane.setStyle("-fx-background-color: purple");
        this.resizePane = new ResizePane(this.parentPane, ResizePane.Orientation.HORIZONTAL, ResizePane.Side.LEFT);
        this.parentPane.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    public void initializeFx () {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    public void setResizePaneFx () {
        this.resizePane.getParentPane().setLayoutX(0);
        this.parentPane.heightProperty().addListener((obs, oldVal, newVal) -> {
           this.resizePane.getParentPane().setMinHeight(newVal.doubleValue());
           this.resizePane.getParentPane().setMaxHeight(newVal.doubleValue());
        });
    }

    // Getters for object's attributes.
    public Pane getParentPane () {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane (Pane parentPane) {
        this.parentPane = parentPane;
    }

}