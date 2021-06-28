package com.flat.controller;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static JsonLanguage jsonLanguage = new JsonLanguage("English", "English", "en");
    private static Stage stage;
    private static JsonData jsonData = JsonData.getInstance();

    // Retrieves view associated with the enum and displays it on stage.
    public static void changeView(View _view) {
        Controller.stage.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the enum.
    public static Pane getView(View _view) {
        switch (_view) {
            case MAIN:
                return new MainView().getParentPane();
            case SETTINGS:
            default:
                return new Pane();
        }
    }

    public static void resetView() {
        Controller.changeView(View.MAIN);
    }

    // Getters for object's attributes.
    public static Stage getStage() {
        return Controller.stage;
    }

    // Setters for for object's attributes.
    public static void setStage(Stage stage) {
        Controller.stage = stage;
    }

    public static JsonLanguage getJsonLanguage() {
        return jsonLanguage;
    }

    public static void setJsonLanguage(JsonLanguage _language) {
        Controller.jsonLanguage = _language;
        Controller.jsonData.update(_language);
    }

    public static JsonData getJsonData() {
        return jsonData;
    }

    public static void setJsonData(JsonData jsonData) {
        Controller.jsonData = jsonData;
    }

}