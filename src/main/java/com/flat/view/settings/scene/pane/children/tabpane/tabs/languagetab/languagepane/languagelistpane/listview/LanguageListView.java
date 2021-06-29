package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview;

import com.flat.models.fx.FxLanguageData;
import com.flat.models.json.language.JsonLanguage;
import javafx.scene.control.ListView;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListView extends ListView {
    private static JsonLanguage selectedLanguage;

    public LanguageListView() {
        super.getItems().addAll(FxLanguageData.getLanguages());
        super.setCellFactory(param -> new LanguageListCell());
        super.setMaxHeight(300);
        this.setOnMouseClicked();
    }

    // Getters for object's attributes.
    public static JsonLanguage getSelectedLanguage() {
        return selectedLanguage;
    }

    private void setOnMouseClicked() {
        super.setOnMouseClicked(event -> {
            LanguageListView.selectedLanguage = (JsonLanguage) super.getSelectionModel().getSelectedItem();
        });
    }

}