package com.flat.controller;

import com.flat.input.FLATErrorListener;
import com.flat.input.FLATParserAdapter;
import com.flat.input.events.SolvedFormula;
import com.flat.input.events.UnsolvedFormula;
import com.flat.models.TimeoutManager;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.treenode.WffTree;
import com.flat.tools.eventbus.EventBus;
import com.flat.tools.font.FontTool;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import com.flat.view.viewdata.settings.SettingsData;
import java.util.ArrayList;
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
    private final static EventBus eventBus = EventBus.getInstance();

    // Retrieves view associated with the enum and displays it on stage.
    public static void changeView (View _view) {
        stage.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the enum.
    public static Pane getView (View _view) {
        switch (_view) {
            case MAIN:
                return new MainView();
            case SETTINGS:
            default:
                return new Pane();
        }
    }

    public static void applyFont (Stage _stage) {
        _stage.getScene().getRoot().setStyle("-fx-font-family: " + jsonLanguage.getFont().getFamily());
    }

    public static void inputFormula (String _formula) {
        ArrayList <WffTree> linkedTree = FLATParserAdapter.getAbstractSyntaxTree(_formula);
        Controller.throwSyntaxErrors();
        Controller.throwSyntaxWarnings();
        if (linkedTree != null)
            Controller.eventBus.throwEvent(new SolvedFormula(linkedTree.get(0)));
        else
            Controller.eventBus.throwEvent(new UnsolvedFormula());
    }

    public static void throwSyntaxErrors () {
        FLATErrorListener.getErrorIterator().forEachRemaining(error -> {
        });
    }

    public static void throwSyntaxWarnings () {
        FLATErrorListener.getWarningIterator().forEachRemaining(error -> {
        });
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

    public static EventBus getEventBus() {
        return eventBus;
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

}