package com.flat.view.main;

import com.flat.view.main.panes.bottom.MainBottom;
import com.flat.view.main.panes.right.MainRight;
import com.flat.view.main.panes.center.MainCenter;
import com.flat.view.main.panes.top.MainTop;
import com.flat.view.main.panes.left.MainLeft;
import com.flat.controller.Controller;
import javafx.scene.layout.BorderPane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainView extends BorderPane {
    private final MainTop mainTop = new MainTop();
    private final MainRight mainRight = new MainRight();
    private final MainBottom mainBottom = new MainBottom();
    private final MainLeft mainLeft = new MainLeft();
    private final MainCenter mainCenter = new MainCenter();

    public MainView() {
        super.setTop(this.mainTop);
        super.setRight(this.mainRight);
        super.setBottom(this.mainBottom);
        super.setLeft(this.mainLeft);
        super.setCenter(this.mainCenter);
        this.initializeFxProperties();
        this.setStageMaximizedListener();
        this.setOnMouseEntered();
    }

    private void setOnMouseEntered () {
        super.setOnMouseEntered(event -> {
            this.mainTop.getFlatMenuPane().closeMenus();
        });
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
        Controller.STAGE.maximizedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                super.getChildren().forEach((child) -> {
                });
            }
        });
    }

    // Setters for initial FX properties.
    private void setMainTopFx() {
    }

    private void setMainRightFx() {
        this.mainRight.setPrefWidth(100);
    }

    private void setMainBottomFx() {
        this.mainBottom.setPrefHeight(100);
    }

    private void setMainLeftFx() {
        this.mainLeft.setPrefWidth(100);
    }

    private void setMainCenterFx() {
        this.mainCenter.setMinSize(0,0);
    }

}