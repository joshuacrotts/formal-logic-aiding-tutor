package com.flat.controller;

import com.flat.models.TimeoutManager;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.font.FontTool;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import com.flat.view.settings.SettingsStage;
import com.flat.view.viewdata.SettingsData;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static JsonLanguage jsonLanguage = new JsonLanguage("English", "English", "en", FontFamily.DEFAULT);
    private static Stage stage;
    private static SettingsStage settingsStage;
    private final static JsonData JSONDATA = JsonData.getInstance();
    private final static FontTool FONTTOOL = FontTool.getInstance();

    // Retrieves view associated with the enum and displays it on stage.
    public static void changeView (View _view) {
        stage.getScene().setRoot(Controller.getView(_view));
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

    public static void applyFont (Stage _stage) {
        _stage.getScene().getRoot().setStyle("-fx-font-family: " + jsonLanguage.getFont().getFamily());
    }

    public static boolean updateTimeouts () {
        return TimeoutManager.updateConstraints(
                Integer.valueOf(SettingsData.getPredicateNDVTimeout().getText()),
                Integer.valueOf(SettingsData.getPredicateTruthTreeTimeout().getText()),
                Integer.valueOf(SettingsData.getPropositionalNDVTimeout().getText()),
                Integer.valueOf(SettingsData.getPropositionalTruthTreeTimeout().getText()),
                Integer.valueOf(SettingsData.getTruthTableTimeout().getText())
        );
    }

    public static void resetView () {
        Controller.changeView(View.MAIN);
    }

    // Getters for object's attributes.
    public static JsonLanguage getJsonLanguage () {
        return jsonLanguage;
    }

    public static Stage getStage () {
        return stage;
    }

    public static JsonData getJSONDATA () {
        return JSONDATA;
    }

    public static FontTool getFONTTOOL () {
        return FONTTOOL;
    }

    public static SettingsStage getSettingsStage() {
        return settingsStage;
    }

    // Setters for for object's attributes.
    public static void setStage (Stage stage) {
        Controller.stage = stage;
        Controller.applyFont(stage);
    }

    public static void setJsonLanguage (JsonLanguage _language) {
        jsonLanguage = _language;
        JSONDATA.update(_language);
        Controller.applyFont(stage);
    }

    public static void setSettingsStage(SettingsStage settingsStage) {
        Controller.settingsStage = settingsStage;
    }

}