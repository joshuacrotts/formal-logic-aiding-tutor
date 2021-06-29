package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.font.enums.FontLocal;
import javafx.scene.control.ListCell;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListCell extends ListCell<JsonLanguage> {

    public LanguageListCell () {
    }

    @Override
    protected void updateItem(JsonLanguage _language, boolean _empty) {
        super.updateItem(_language, _empty);
        if (!(_language == null) && !(_empty)) {
            if (!_language.getFont().equals(FontLocal.FontFamily.DEFAULT))
                this.setStyle("-fx-font-family: " + _language.getFont().getFamily());
            this.setText(_language.getNativeName());
        }
    }

}