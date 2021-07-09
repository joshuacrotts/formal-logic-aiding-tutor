package com.flat;

import com.flat.controller.Controller;
import com.flat.view.enums.View;
import com.flat.view.tools.ResourceManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        System.setProperty("GOOGLE_API_KEY", "AIzaSyBWaA57xlPumWThhPfGmHSkPFj82fMRa1Y");
        Application.setUserAgentStylesheet(ResourceManager.getDefaultStyle());
        this.initializeStage(_stage);
        Controller.setStage(_stage);
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