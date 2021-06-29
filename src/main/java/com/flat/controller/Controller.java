package com.flat.controller;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.font.FontTool;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static JsonLanguage jsonLanguage = new JsonLanguage("English", "English", "en", FontFamily.DEFAULT);
    private static Stage stage;
    private final static JsonData JSONDATA = JsonData.getInstance();
    private final static FontTool FONTTOOL = FontTool.getInstance();

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
    public static JsonLanguage getJsonLanguage() {
        return jsonLanguage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static JsonData getJSONDATA() {
        return JSONDATA;
    }

    public static FontTool getFONTTOOL() {
        return FONTTOOL;
    }

    // Setters for for object's attributes.
    public static void setStage(Stage stage) {
        Controller.stage = stage;
    }

    public static void setJsonLanguage(JsonLanguage _language) {
        Controller.jsonLanguage = _language;
        Controller.JSONDATA.update(_language);
    }

}