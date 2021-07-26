package com.flat.view.settings;

import com.flat.controller.Controller;
import com.flat.models.data.settings.Settings;
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
        super.titleProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.TITLE).textProperty());
        super.initModality(Modality.WINDOW_MODAL);
        super.initOwner(Controller.STAGE.getScene().getWindow());
    }

    private void setSize() {
        super.setWidth(800);
        super.setHeight(450);
    }

    private void centerOnStage() {
        super.setX(Controller.STAGE.getX() + ((Controller.STAGE.getWidth() - super.getWidth()) / 2));
        super.setY(Controller.STAGE.getY() + ((Controller.STAGE.getHeight() - super.getHeight()) / 2));
    }

}