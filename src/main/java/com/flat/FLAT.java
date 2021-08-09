package com.flat;

import com.flat.controller.Controller;
import com.flat.view.enums.View;
import com.flat.view.tools.ResourceManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

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
        List<String> fontFamilies = Font.getFamilies();
        for (String fontFamily: fontFamilies) {
            Font.font(fontFamily);
        }
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