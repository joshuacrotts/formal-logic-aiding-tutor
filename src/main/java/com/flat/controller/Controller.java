package com.flat.controller;

import com.flat.models.json.language.Language;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static Stage stage;
    private final static Language language = new Language("English", "English", "en");
    private static JsonData jsonData = new JsonData();

    // Retrieves view associated with the enum and displays it on stage.
    public static void changeView (View _view) {
        Controller.stage.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the enum.
    public static Pane getView (View _view) {
        switch (_view) {
            case MAIN:
                return new MainView().getParentPane();
            case SETTINGS:
            default:
                return new Pane();   
        }
    }

    public static void resetView () {
        Controller.changeView(View.MAIN);
    }

    // Getters for object's attributes.
    public static Stage getStage() {
        return Controller.stage;
    }

    public static Language getLanguage() {
        return language;
    }

    public static JsonData getJsonData() {
        return jsonData;
    }

    // Setters for for object's attributes.
    public static void setStage(Stage stage) {
        Controller.stage = stage;
    }

    public static void setLanguage(Language _language) {
        Controller.language.setNativeName(_language.getNativeName());
        Controller.language.setLanguageName(_language.getLanguageName());
        Controller.language.setCode(_language.getCode());
        Controller.language.notifyObservers();
    }

    public static void setJsonData(JsonData jsonData) {
        Controller.jsonData = jsonData;
    }

}