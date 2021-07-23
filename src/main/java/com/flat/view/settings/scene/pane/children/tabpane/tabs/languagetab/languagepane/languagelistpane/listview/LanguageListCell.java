package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.font.FontTool;
import javafx.scene.control.ListCell;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListCell extends ListCell<JsonLanguage> {

    public LanguageListCell() {
    }

    @Override
    protected void updateItem(JsonLanguage _language, boolean _empty) {
        super.updateItem(_language, _empty);
        if (!(_language == null) && !(_empty)) {
            this.setFont(FontTool.getFont(_language.getFont()));
            this.setText(_language.getNativeName());
        }
    }

}