package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.view.viewdata.SettingsData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview.LanguageListView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageApplyButton extends Button {

    public LanguageApplyButton() {
        super.textProperty().bind(SettingsData.getApply().textProperty());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction(event -> {
            if (!(LanguageListView.getSelectedLanguage() == null)) {
                Controller.setJsonLanguage(LanguageListView.getSelectedLanguage());
                Controller.applyFont((Stage) super.getScene().getWindow());
            }
        });
    }

}