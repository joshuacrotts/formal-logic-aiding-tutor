package com.flat.view.settings.scene.pane.children.selection.language.languagepane.buttonbar;

import com.flat.view.settings.scene.pane.children.buttons.SettingsCloseButton;
import com.flat.view.settings.scene.pane.children.selection.language.languagepane.buttonbar.button.LanguageApplyButton;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageButtonBar extends ButtonBar {
    private LanguageApplyButton applyButton = new LanguageApplyButton();
    private SettingsCloseButton closeButton = new SettingsCloseButton();

    public LanguageButtonBar() {
        ButtonBar.setButtonData(this.applyButton, ButtonData.APPLY);
        ButtonBar.setButtonData(this.closeButton, ButtonData.CANCEL_CLOSE);
        super.getButtons().addAll(this.applyButton, this.closeButton);
        super.setPadding(new Insets(10, 10, 10, 10));
    }

}