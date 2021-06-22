package com.flat.controller;

import com.flat.view.ViewEnum;
import com.flat.view.main.Main;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static Stage stage;

    // Retrieves view associated with the enum and displays it on stage.
    public static void changeView (ViewEnum _view) {
        Controller.stage.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the enum.
    public static Pane getView (ViewEnum _view) {
        switch (_view) {
            case MAIN:
                return new Main().getParentPane();
            case SETTINGS:
            default:
                return new Pane();   
        }
    }

    // Getters for object's attributes.
    public static Stage getStage() {
        return Controller.stage;
    }

    // Setters for for object's attributes.
    public static void setStage(Stage stage) {
        Controller.stage = stage;
    }

}