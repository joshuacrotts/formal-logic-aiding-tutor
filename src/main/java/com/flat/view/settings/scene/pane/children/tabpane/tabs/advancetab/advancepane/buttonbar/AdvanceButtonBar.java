package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar;

import com.flat.view.settings.scene.pane.children.buttons.SettingsCloseButton;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar.button.AdvanceApplyButton;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceButtonBar extends ButtonBar {
    private AdvanceApplyButton applyButton = new AdvanceApplyButton();
    private SettingsCloseButton closeButton = new SettingsCloseButton();

    public AdvanceButtonBar () {
        ButtonBar.setButtonData(this.applyButton, ButtonBar.ButtonData.APPLY);
        ButtonBar.setButtonData(this.closeButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        super.getButtons().addAll(this.applyButton, this.closeButton);
        super.setPadding(new Insets(10, 10, 10, 10));
    }

}