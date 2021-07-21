package com.flat;

import com.flat.controller.Controller;
import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.json.JsonTools;
import com.flat.tools.json.enums.JsonLocal;
import com.flat.view.enums.View;
import com.flat.view.tools.ResourceManager;
import java.io.UnsupportedEncodingException;
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
    public enum TestKey implements KeyBase {
        TEST,
    }

    @Override
    public void start(Stage _stage) throws UnsupportedEncodingException {
        JsonTools.serializeObject(JsonLanguage.DEFAULT, JsonLocal.File.MENUBAR, new KeyedText(KeyedText.class, TestKey.TEST, "Hello"), KeyedText.class);
        KeyedText string = JsonTools.deserializeObject(JsonLanguage.DEFAULT, JsonLocal.File.MENUBAR, KeyedText.class);
        System.out.println(string.toString());
        System.out.println(string.getText());
        System.out.println("Done");
        if (true)
            System.exit(0);
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