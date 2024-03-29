package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.buttonbar;

import com.flat.view.settings.scene.pane.children.buttons.SettingsCloseButton;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.buttonbar.button.AdvancedApplyButton;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvancedButtonBar extends ButtonBar {
    private AdvancedApplyButton applyButton = new AdvancedApplyButton();
    private SettingsCloseButton closeButton = new SettingsCloseButton();

    public AdvancedButtonBar () {
        ButtonBar.setButtonData(this.applyButton, ButtonData.APPLY);
        ButtonBar.setButtonData(this.closeButton, ButtonData.CANCEL_CLOSE);
        super.getButtons().addAll(this.applyButton, this.closeButton);
        super.setPadding(new Insets(10, 10, 10, 10));
    }

}