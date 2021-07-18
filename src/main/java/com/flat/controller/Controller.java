package com.flat.controller;

import com.flat.input.FLATErrorListener;
import com.flat.input.FLATParserAdapter;
import com.flat.input.events.UnsolvedFormula;
import com.flat.models.TimeoutManager;
import com.flat.models.algorithms.ApplyAlgorithmAdapter;
import com.flat.models.json.algorithm.JsonAlgorithm;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.treenode.WffTree;
import com.flat.tools.eventbus.EventBus;
import com.flat.tools.eventbus.events.parsererrors.SyntaxError;
import com.flat.tools.eventbus.events.parsererrors.SyntaxWarning;
import com.flat.tools.font.FontTool;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import com.flat.tools.json.JsonData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeLayout;
import com.flat.view.viewdata.algorithms.AvailableAlgorithms;
import com.flat.view.viewdata.settings.SettingsData;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    private static JsonLanguage JSON_LANGUAGE = new JsonLanguage("English", "English", "en", FontFamily.DEFAULT);
    private static Stage STAGE;
    private final static JsonData JSON_DATA = JsonData.getInstance();
    private final static FontTool FONT_TOOL = FontTool.getInstance();
    private final static EventBus EVENT_BUS = EventBus.getInstance();
    private final static ApplyAlgorithmAdapter ALGORITHM_ADAPTER = new ApplyAlgorithmAdapter(JSON_DATA.getJsonAlgorithms());
    private final static TreeLayout TREE_LAYOUT = new TreeLayout(50, 40);

    // Retrieves view associated with the enum and displays it on STAGE.
    public static void changeView (View _view) {
        STAGE.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the enum.
    public static Pane getView (View _view) {
        switch (_view) {
            case MAIN:
                updateFxAvailableAlgorithms();
                return new MainView();
            case SETTINGS:
            default:
                return new Pane();
        }
    }

    public static void applyFont (Stage _stage) {
        _stage.getScene().getRoot().setStyle("-fx-font-family: " + JSON_LANGUAGE.getFont().getFamily());
    }

    public static void inputFormula (String _formula) {
        ArrayList <WffTree> linkedTree = FLATParserAdapter.getAbstractSyntaxTree(_formula);
        Controller.throwSyntaxErrors();
        Controller.throwSyntaxWarnings();
        if (linkedTree != null)
            ALGORITHM_ADAPTER.setWffTree(linkedTree);
        else
            EVENT_BUS.throwEvent(new UnsolvedFormula());
        updateFxAvailableAlgorithms();
    }

    public static void updateFxAvailableAlgorithms () {
        AvailableAlgorithms.clearAlgorithms();
        AvailableAlgorithms.addGeneralAlgorithms(ALGORITHM_ADAPTER.getApplicableAlgorithms().getGeneral());
        AvailableAlgorithms.addPredicateAlgorithms(ALGORITHM_ADAPTER.getApplicableAlgorithms().getPredicate());
        AvailableAlgorithms.addPropositionalAlgorithms(ALGORITHM_ADAPTER.getApplicableAlgorithms().getPropositional());
    }

    public static void throwSyntaxErrors () {
        EVENT_BUS.throwEvent(new SyntaxError(FLATErrorListener.getErrorIterator()));
    }

    public static void throwSyntaxWarnings () {
        EVENT_BUS.throwEvent(new SyntaxWarning(FLATErrorListener.getWarningIterator()));
    }

    public static void applyFormula (JsonAlgorithm _jsonAlgorithm) {
        ALGORITHM_ADAPTER.apply(_jsonAlgorithm);
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

    public static void updateModelData () {
        ALGORITHM_ADAPTER.setJsonAlgorithms(Controller.JSON_DATA.getJsonAlgorithms());
        updateFxAvailableAlgorithms();
    }

    public static void resetView () {
        changeView(View.MAIN);
    }

    // Getters for object's attributes.
    public static JsonLanguage getJSON_LANGUAGE () {
        return JSON_LANGUAGE;
    }

    public static Stage getSTAGE () {
        return STAGE;
    }

    public static JsonData getJSON_DATA () {
        return JSON_DATA;
    }

    public static FontTool getFONT_TOOL () {
        return FONT_TOOL;
    }

    public static EventBus getEVENT_BUS() {
        return EVENT_BUS;
    }

    public static ApplyAlgorithmAdapter getALGORITHM_ADAPTER() {
        return ALGORITHM_ADAPTER;
    }

    public static TreeLayout getTREE_LAYOUT() {
        return TREE_LAYOUT;
    }

    // Setters for for object's attributes.
    public static void setSTAGE (Stage STAGE) {
        Controller.STAGE = STAGE;
        Controller.applyFont(STAGE);
    }

    public static void setJSON_LANGUAGE (JsonLanguage _language) {
        JSON_LANGUAGE = _language;
        JSON_DATA.update(_language);
        updateModelData();
        Controller.applyFont(STAGE);
    }

}