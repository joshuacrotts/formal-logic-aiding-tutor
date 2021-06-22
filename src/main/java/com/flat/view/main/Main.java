package com.flat.view.main;

import com.flat.controller.Controller;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Main {
    private BorderPane parentPane = new BorderPane();
    private MainTop mainTop = new MainTop();
    private MainRight mainRight = new MainRight();
    private MainBottom mainBottom = new MainBottom();
    private MainLeft mainLeft = new MainLeft();
    private MainCenter mainCenter = new MainCenter();

    public Main () {
        this.parentPane.setTop(this.mainTop.getParentPane());
        this.parentPane.setRight(this.mainRight.getParentPane());
        this.parentPane.setBottom(this.mainBottom.getParentPane());
        this.parentPane.setLeft(this.mainLeft.getParentPane());
        this.parentPane.setCenter(this.mainCenter.getParentPane());
        this.initializeFxProperties();
        this.setStageMaximizedListener();
    }

    // Calls all FX property setters.
    public void initializeFxProperties () {
        this.setMainTopFx();
        this.setMainRightFx();
        this.setMainBottomFx();
        this.setMainLeftFx();
        this.setMainCenterFx();
    }

    public void setStageMaximizedListener () {
        Controller.getStage().maximizedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                this.parentPane.getChildren().forEach((child) -> {
                });
            }
        });
    }

    // Setters for initial FX properties.
    public void setMainTopFx () {
        this.mainTop.getParentPane().setPrefHeight(100);
    }

    public void setMainRightFx () {
        this.mainRight.getParentPane().setPrefWidth(100);
    }

    public void setMainBottomFx () {
        this.mainBottom.getParentPane().setPrefHeight(100);
    }

    public void setMainLeftFx () {
        this.mainLeft.getParentPane().setPrefWidth(100);
    }

    public void setMainCenterFx () {
        this.mainCenter.getParentPane().setMaxSize(100, 100);
    }

    // Getters for object's attributes.
    public Pane getParentPane () {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane (BorderPane parentPane) {
        this.parentPane = parentPane;
    }

}