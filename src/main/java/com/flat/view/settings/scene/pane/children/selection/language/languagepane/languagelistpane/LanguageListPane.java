package com.flat.view.settings.scene.pane.children.selection.language.languagepane.languagelistpane;

import com.flat.view.settings.scene.pane.children.selection.language.languagepane.languagelistpane.listview.LanguageListViewPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListPane extends HBox {
    private LanguageListViewPane languageListPane = new LanguageListViewPane();

    public LanguageListPane() {
        super.getChildren().addAll(this.languageListPane);
        super.setAlignment(Pos.CENTER);
    }

}