package com.flat.controller;

import com.flat.input.FLATErrorListener;
import com.flat.input.FLATParserAdapter;
import com.flat.input.events.UnsolvedFormula;
import com.flat.models.TimeoutManager;
import com.flat.models.algorithms.ApplyAlgorithmAdapter;
import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.databus.DataBus;
import com.flat.tools.data.json.JsonData;
import com.flat.tools.data.serial.SerialData;
import com.flat.tools.buses.eventbus.EventBus;
import com.flat.tools.translation.FLATTranslate;
import com.flat.view.data.fx.FxData;
import com.flat.view.enums.View;
import com.flat.view.main.MainView;
import com.flat.view.main.panes.center.children.trees.base.treelayout.TreeLayout;
import com.flat.view.popups.syntax.error.SyntaxErrorPopup;
import com.flat.view.data.MappedText;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Controller {
    public static Stage STAGE;
    public static JsonLanguage JSON_LANGUAGE = JsonLanguage.DEFAULT;
    public final static EventBus EVENT_BUS = EventBus.getInstance();
    public final static DataBus DATA_BUS = DataBus.getInstance();
    public final static FLATTranslate TRANSLATOR = new FLATTranslate();;
    public final static MappedText MAPPED_TEXT = new MappedText();
    public final static SerialData SERIAL_DATA = SerialData.getInstance(JSON_LANGUAGE);;
    public final static FxData FX_DATA = FxData.getInstance();;
    public final static JsonData JSON_DATA = JsonData.getInstance(JSON_LANGUAGE);;
    public final static ApplyAlgorithmAdapter ALGORITHM_ADAPTER = new ApplyAlgorithmAdapter(SERIAL_DATA.getAlgorithms());;
    public final static TreeLayout TREE_LAYOUT = new TreeLayout(50, 40);

    // Retrieves view associated with the enum and displays it on STAGE.
    public static void changeView (View _view) {
        Controller.STAGE.getScene().setRoot(Controller.getView(_view));
    }

    // Returns the view associated with the View enum.
    public static Pane getView (View _view) {
        switch (_view) {
            case MAIN:
                return new MainView();
            case SETTINGS:
            default:
                return new Pane();
        }
    }

    public static void inputFormula (String _formula) {
        ArrayList <WffTree> linkedTree = FLATParserAdapter.getAbstractSyntaxTree(_formula);
        Controller.throwSyntaxErrors();
        if (linkedTree != null)
            ALGORITHM_ADAPTER.setWffTree(linkedTree);
        else
            EVENT_BUS.throwEvent(new UnsolvedFormula());
    }

    public static void throwSyntaxErrors () {
        if (FLATErrorListener.getErrorIterator().hasNext())
            new SyntaxErrorPopup(FLATErrorListener.getErrorIterator());
    }

    public static void applyFormula (Algorithm _algorithm) {
        ALGORITHM_ADAPTER.apply(_algorithm);
    }

    public static boolean updateTimeouts () {
        return TimeoutManager.updateConstraints();
    }

    public static void resetView () {
        Controller.changeView(View.MAIN);
    }

    // Setters for for object's attributes.
    public static void setSTAGE (Stage STAGE) {
        Controller.STAGE = STAGE;
    }

    public static void setJSON_LANGUAGE (JsonLanguage _language) {
        JSON_LANGUAGE = _language;
        SERIAL_DATA.update(_language);
    }

}