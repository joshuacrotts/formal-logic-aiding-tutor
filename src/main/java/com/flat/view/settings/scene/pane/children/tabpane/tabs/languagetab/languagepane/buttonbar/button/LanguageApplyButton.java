package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.buttonbar.button;

import com.flat.controller.Controller;
import com.flat.models.json.settings.JsonSettings;
import com.flat.view.data.json.KeyedText;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview.LanguageListView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageApplyButton extends Button {

    public LanguageApplyButton() {
        super.textProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonSettings.class), KeyedText.toKey2(JsonSettings.Keys.APPLY)).textProperty());
        super.fontProperty().bind(Controller.getKEYED_TEXT().getValue(KeyedText.toKey1(JsonSettings.class), KeyedText.toKey2(JsonSettings.Keys.APPLY)).fontProperty());

        this.setOnAction();
    }

    private void setOnAction() {
        super.setOnAction(event -> {
            if (!(LanguageListView.getSelectedLanguage() == null)) {
                Controller.setJSON_LANGUAGE(LanguageListView.getSelectedLanguage());
                // Extend stage to have a list of scenes to remove this line.
                Controller.applyFont(((Stage)this.getScene().getWindow()));
            }
        });
    }

}