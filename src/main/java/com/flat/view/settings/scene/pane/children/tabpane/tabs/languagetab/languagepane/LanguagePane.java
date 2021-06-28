package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistview.LanguageListView;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguagePane extends Pane {
    private LanguageListView languageListView = new LanguageListView();

    public LanguagePane() {
        super.getChildren().addAll(this.languageListView);
        super.setStyle("-fx-background-color: brown");
    }

}