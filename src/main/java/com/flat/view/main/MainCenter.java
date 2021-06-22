package com.flat.view.main;

import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainCenter {
    private Pane parentPane = new Pane();

    public MainCenter () {
        this.parentPane.setStyle("-fx-background-color: blue");
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