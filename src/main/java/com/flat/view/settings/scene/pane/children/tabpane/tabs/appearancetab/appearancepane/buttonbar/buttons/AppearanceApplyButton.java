package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.buttonbar.buttons;

import com.flat.view.viewdata.PreviewData;
import com.flat.view.viewdata.SettingsData;
import com.flat.view.viewdata.border.BorderData;
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
            BorderData.getTopProperty().getBackgroundProperties().setColor(PreviewData.getPrimaryColor().getColor());
            BorderData.getRightProperty().getBackgroundProperties().setColor(PreviewData.getSecondaryColor().getColor());
            BorderData.getBottomProperty().getBackgroundProperties().setColor(PreviewData.getPrimaryColor().getColor());
            BorderData.getLeftProperty().getBackgroundProperties().setColor(PreviewData.getSecondaryColor().getColor());
        });
    }

}