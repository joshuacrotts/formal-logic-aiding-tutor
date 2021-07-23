package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.data.settings.Settings;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview.LanguageListView;
import javafx.scene.control.Button;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageApplyButton extends Button {

    public LanguageApplyButton() {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(Settings.class, Settings.Keys.APPLY).fontProperty());
        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction(event -> {
            if (!(LanguageListView.getSelectedLanguage() == null)) {
                Controller.setJSON_LANGUAGE(LanguageListView.getSelectedLanguage());
            }
        });
    }

}