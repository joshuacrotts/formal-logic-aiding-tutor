package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.buttonbar.buttons;

import com.flat.view.viewdata.settings.AppearancePreviewData;
import com.flat.view.viewdata.settings.SettingsData;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceApplyButton extends Button {

    public  AppearanceApplyButton () {
        super.textProperty().bind(SettingsData.getApply().textProperty());
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