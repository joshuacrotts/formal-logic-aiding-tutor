package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.buttonbar.buttons;

import com.flat.controller.Controller;
import com.flat.models.data.settings.Settings;
import com.flat.view.data.fx.pane.PaneData;
import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceApplyButton extends Button {

    public  AppearanceApplyButton () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).fontProperty());
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