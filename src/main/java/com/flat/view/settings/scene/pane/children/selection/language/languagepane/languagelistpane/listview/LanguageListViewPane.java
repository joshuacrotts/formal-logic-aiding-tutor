package com.flat.view.settings.scene.pane.children.selection.language.languagepane.languagelistpane.listview;

import com.flat.view.settings.scene.pane.children.selection.language.languagepane.languagelistpane.listview.children.LanguageListView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageListViewPane extends VBox {
    private LanguageListView languageListView = new LanguageListView();

    public LanguageListViewPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.languageListView);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        super.setPadding(new Insets(10));
        super.setMaxHeight(300);
        super.getStyleClass().add("languageListViewPane");
    }

}