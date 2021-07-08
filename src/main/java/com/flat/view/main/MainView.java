package com.flat.view.main;

import com.flat.view.main.panes.MainBottom;
import com.flat.view.main.panes.MainRight;
import com.flat.view.main.panes.MainCenter;
import com.flat.view.main.panes.MainTop;
import com.flat.view.main.panes.MainLeft;
import com.flat.controller.Controller;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainView {
    private final MainTop mainTop = new MainTop();
    private final MainRight mainRight = new MainRight();
    private final MainBottom mainBottom = new MainBottom();
    private final MainLeft mainLeft = new MainLeft();
    private final MainCenter mainCenter = new MainCenter();
    private BorderPane parentPane = new BorderPane();

    public MainView() {
        this.parentPane.setTop(this.mainTop);
        this.parentPane.setRight(this.mainRight);
        this.parentPane.setBottom(this.mainBottom);
        this.parentPane.setLeft(this.mainLeft);
        this.parentPane.setCenter(this.mainCenter);
        this.initializeFxProperties();
        this.setStageMaximizedListener();
    }

    // Calls all FX property setters.
    private void initializeFxProperties() {
        this.setMainTopFx();
        this.setMainRightFx();
        this.setMainBottomFx();
        this.setMainLeftFx();
        this.setMainCenterFx();
    }

    private void setStageMaximizedListener() {
        Controller.getStage().maximizedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                this.parentPane.getChildren().forEach((child) -> {
                });
            }
        });
    }

    // Setters for initial FX properties.
    public void setMainTopFx() {
    }

    public void setMainRightFx() {
        this.mainRight.setPrefWidth(100);
    }

    public void setMainBottomFx() {
        this.mainBottom.setPrefHeight(100);
    }

    public void setMainLeftFx() {
        this.mainLeft.setPrefWidth(100);
    }

    public void setMainCenterFx() {
    }

    // Getters for object's attributes.
    public Pane getParentPane() {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane(BorderPane parentPane) {
        this.parentPane = parentPane;
    }

}