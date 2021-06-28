package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistview;

import com.flat.models.fx.FxLanguageData;
import javafx.scene.control.ListView;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListView extends ListView {

    public LanguageListView () {
        super.getItems().addAll(FxLanguageData.getLanguages());
        super.setCellFactory(param -> new LanguageListCell());
    }

}