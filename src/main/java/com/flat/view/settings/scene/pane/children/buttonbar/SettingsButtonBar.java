package com.flat.view.settings.scene.pane.children.buttonbar;

import com.flat.view.settings.scene.pane.children.buttonbar.buttons.SettingsApplyButton;
import com.flat.view.settings.scene.pane.children.buttonbar.buttons.SettingsCloseButton;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsButtonBar extends ButtonBar {
    private SettingsApplyButton settingsApplyButton = new SettingsApplyButton();
    private SettingsCloseButton settingsCloseButton = new SettingsCloseButton();

    public SettingsButtonBar () {
        ButtonBar.setButtonData(this.settingsApplyButton, ButtonData.APPLY);
        ButtonBar.setButtonData(this.settingsCloseButton, ButtonData.CANCEL_CLOSE);
        super.getButtons().addAll(this.settingsApplyButton, this.settingsCloseButton);
        super.setPadding(new Insets(10,10,10,10));
    }

}