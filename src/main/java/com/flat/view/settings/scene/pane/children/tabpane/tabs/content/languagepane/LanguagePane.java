package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.languagepane;

import com.flat.models.fx.FxLanguageData;
import com.flat.models.json.language.JsonLanguage;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguagePane extends Pane {

    public LanguagePane() {
        ListView listView = new ListView();
        listView.getItems().addAll(FxLanguageData.getLanguages());
        listView.setCellFactory(value -> new ListCell<JsonLanguage>() {
            @Override
            protected void updateItem(JsonLanguage _language, boolean _empty) {
                super.updateItem(_language, _empty);
                if(_language != null && _language.getNativeName() != null)
                    setText(_language.getNativeName());
            }
        });
        super.getChildren().add(listView);
        super.setStyle("-fx-background-color: brown");
    }

}