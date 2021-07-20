package com.flat;

import com.flat.controller.Controller;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.logicsymbols.logictype.predicate.symbols.existential.attributes.ExistentialAxioms;
import com.flat.tools.json.JsonTools;
import com.flat.tools.json.enums.JsonLocal;
import com.flat.view.enums.View;
import com.flat.view.tools.ResourceManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FLAT extends Application {

    /**
     * @param _args the command line arguments
     */
    public static void main(String[] _args) {
        launch(_args);
    }

    @Override
    public void start(Stage _stage) {
        /*
        JsonTools.objectToJson(JsonLanguage.DEFAULT, JsonLocal.File.MENUBAR, new KeyedJsonString(KeyedJsonString.class, ExistentialAxioms.Keys.EXAMPLE, "test"), KeyedJsonString.class);
        if (true)
            return;*/
        System.setProperty("GOOGLE_API_KEY", "AIzaSyBWaA57xlPumWThhPfGmHSkPFj82fMRa1Y");
        Application.setUserAgentStylesheet(ResourceManager.getDefaultStyle());
        this.initializeStage(_stage);
        Controller.setSTAGE(_stage);
        Controller.changeView(View.MAIN);
        _stage.show();
    }

    // Applies the initial properties to the stage.
    public void initializeStage(Stage _stage) {
        _stage.setScene(new Scene(new Pane()));
        _stage.setMaximized(true);
        _stage.setMinHeight(720);
        _stage.setMinWidth(1280);
    }

}