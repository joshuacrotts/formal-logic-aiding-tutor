package com.flat.view.main;

import com.flat.controller.Controller;
import com.flat.models.json.language.Language;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainCenter {
    private Pane parentPane = new Pane();

    public MainCenter() {
        this.parentPane.setStyle("-fx-background-color: blue");
        Button button = new Button("Spanish");
        button.setOnAction((event) -> {
            System.out.println("button pressed");
            Controller.setLanguage(new Language("", "", "es"));
            Controller.resetView();
        });
        this.parentPane.getChildren().add(button);
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