package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.buttonbar.buttons;

import com.flat.controller.Controller;
import com.flat.models.json.settings.JsonSettings;
import com.flat.view.data.json.KeyedText;
import com.flat.view.data.fx.settings.AppearancePreviewData;
import com.flat.view.data.fx.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceApplyButton extends Button {

    public  AppearanceApplyButton () {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonSettings.class), KeyedText.toKey2(JsonSettings.Keys.APPLY)).textProperty());
        super.fontProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonSettings.class), KeyedText.toKey2(JsonSettings.Keys.APPLY)).fontProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            PaneData.getTopProperty().getBackgroundProperties().setColor(AppearancePreviewData.getPrimaryColor().getColor());
            PaneData.getRightProperty().getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
            PaneData.getBottomProperty().getBackgroundProperties().setColor(AppearancePreviewData.getPrimaryColor().getColor());
            PaneData.getLeftProperty().getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
            PaneData.getBorderProperty().getBackgroundProperties().setColor(AppearancePreviewData.getBorderColor().getColor());
            PaneData.getPrimaryButtonProperty().getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
        });
    }

}