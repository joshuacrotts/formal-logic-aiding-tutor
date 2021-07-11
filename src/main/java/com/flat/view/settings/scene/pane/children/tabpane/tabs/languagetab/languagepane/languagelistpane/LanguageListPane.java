package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.listview.LanguageListView;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListPane extends HBox {
    private LanguageListView languageListView = new LanguageListView();

    public LanguageListPane() {
        super.getChildren().addAll(this.languageListView);
        super.setAlignment(Pos.CENTER);
    }

}