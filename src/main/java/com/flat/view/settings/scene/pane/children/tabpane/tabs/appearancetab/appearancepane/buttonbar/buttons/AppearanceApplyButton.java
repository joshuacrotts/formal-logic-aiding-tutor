package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.buttonbar.buttons;

import com.flat.controller.Controller;
import com.flat.models.json.settings.JsonSettings;
import com.flat.view.data.json.MappedText;
import com.flat.view.data.fx.settings.AppearancePreviewData;
import com.flat.view.data.fx.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceApplyButton extends Button {

    public  AppearanceApplyButton () {
        super.textProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonSettings.class), MappedText.toKey2(JsonSettings.Keys.APPLY)).textProperty());
        super.fontProperty().bind(Controller.getMAPPED_TEXT().getValue(MappedText.toKey1(JsonSettings.class), MappedText.toKey2(JsonSettings.Keys.APPLY)).fontProperty());
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