package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.buttonbar;

import com.flat.view.settings.scene.pane.children.buttons.SettingsCloseButton;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.buttonbar.buttons.AppearanceApplyButton;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearanceButtonBar extends ButtonBar {
    private AppearanceApplyButton applyButton = new AppearanceApplyButton();
    private SettingsCloseButton closeButton = new SettingsCloseButton();

    public AppearanceButtonBar () {
        ButtonBar.setButtonData(this.applyButton, ButtonData.APPLY);
        ButtonBar.setButtonData(this.closeButton, ButtonData.CANCEL_CLOSE);
        super.getButtons().addAll(this.applyButton, this.closeButton);
        super.setPadding(new Insets(10, 10, 10, 10));
    }

}