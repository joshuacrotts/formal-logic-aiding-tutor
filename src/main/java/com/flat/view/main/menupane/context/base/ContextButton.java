package com.flat.view.main.menupane.context.base;

import com.flat.controller.Controller;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ContextButton extends Button {
    public static double MENU_WIDTH = 120;
    public static double MENU_HEIGHT = 30;
    private ContextStage stage = new ContextStage();
    private ContextWindow contextWindow = new ContextWindow();
    private boolean toggle = false;
    private double offsetX = 0;
    private double offsetY = 0;

    public ContextButton (StringProperty _stringProperty) {
        super.textProperty().bind(_stringProperty);
        super.setPrefWidth(MENU_WIDTH);
        super.setPrefHeight(MENU_HEIGHT);
    }

    public ContextButton (StringProperty _stringProperty, ContextButton... _flatMenuItems) {
        this(_stringProperty);
        this.contextWindow.getChildren().addAll(_flatMenuItems);
        this.contextWindow.setPrefWidth(MENU_WIDTH);
        this.contextWindow.setPrefHeight(MENU_HEIGHT);
        this.stage.setScene(new Scene(this.contextWindow));
        this.setOnMouseThis();
    }

    private void applyFont () {
        if (this.stage != null)
            if (this.stage.getScene() != null)
                if (this.stage.getScene().getRoot() != null)
                    Controller.applyFont(this.stage);
    }

    private void layoutStage () {
        this.stage.setX(this.getScene().getWindow().getX() + this.getScene().getX() + this.getLayoutX() +  this.offsetX);
        this.stage.setY(this.getScene().getWindow().getY() + this.getScene().getY() + this.getLayoutY() + this.getHeight() + this.offsetY);
    }

    private void toggleStage () {
        if (toggle)
            this.stage.hide();
        else
            this.stage.show();
        toggle ^= true;
    }

    private void setOnMouseThis () {
        this.setOnMouseEnteredThis();
    }

    protected void setOnMouseEnteredThis () {
        super.setOnMouseEntered(event -> {
            this.applyFont();
            this.layoutStage();
            this.toggleStage();
        });
    }

    public void closeMenus () {
        if (this.stage.showingProperty().get()) {
            this.stage.hide();
            this.toggle = false;
        }
        this.contextWindow.getChildren().forEach(child -> {
            ((ContextButton)child).closeMenus();
        });
    }

    // Getters for object's attributes.
    public static double getMENU_WIDTH() {
        return MENU_WIDTH;
    }

    public static double getMENU_HEIGHT() {
        return MENU_HEIGHT;
    }

    public ContextStage getStage() {
        return stage;
    }

    public ContextWindow getContextWindow() {
        return contextWindow;
    }

    public boolean isToggle() {
        return toggle;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    // Setters for object's attributes.
    public static void setMENU_WIDTH(double MENU_WIDTH) {
        ContextButton.MENU_WIDTH = MENU_WIDTH;
    }

    public static void setMENU_HEIGHT(double MENU_HEIGHT) {
        ContextButton.MENU_HEIGHT = MENU_HEIGHT;
    }

    public void setStage(ContextStage stage) {
        this.stage = stage;
    }

    public void setContextWindow(ContextWindow contextWindow) {
        this.contextWindow = contextWindow;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
        if (!this.toggle)
            this.stage.hide();
        else {
            this.applyFont();
            this.layoutStage();
            this.stage.show();
        }
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

}