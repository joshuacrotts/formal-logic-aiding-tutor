package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.fx.FxSettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview.LanguageListView;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageApplyButton extends Button {

    public LanguageApplyButton () {
        super.textProperty().bind(FxSettingsData.getApply().textProperty());
        this.setOnAction();
    }

    private void setOnAction () {
        super.setOnAction(event -> {
            if (!(LanguageListView.getSelectedLanguage() == null))
                Controller.setJsonLanguage(LanguageListView.getSelectedLanguage());
        });
    }

}