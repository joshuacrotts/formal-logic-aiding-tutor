package com.flat.view.settings;

import com.flat.controller.Controller;
import com.flat.view.data.settings.SettingsData;
import com.flat.view.settings.scene.SettingsScene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsStage extends Stage {
    private final SettingsScene settingsScene = new SettingsScene();

    public SettingsStage() {
        super.setScene(settingsScene);
        this.setFxProperties();
        super.show();
        this.setSize();
        this.centerOnStage();
    }

    private void setFxProperties() {
        super.titleProperty().bind(SettingsData.getTitle().textProperty());
        super.initModality(Modality.WINDOW_MODAL);
        super.initOwner(Controller.getSTAGE().getScene().getWindow());
    }

    private void setSize() {
        super.setWidth(1280);
        super.setHeight(720);
    }

    private void centerOnStage() {
        super.setX(Controller.getSTAGE().getX() + ((Controller.getSTAGE().getWidth() - super.getWidth()) / 2));
        super.setY(Controller.getSTAGE().getY() + ((Controller.getSTAGE().getHeight() - super.getHeight()) / 2));
    }

}