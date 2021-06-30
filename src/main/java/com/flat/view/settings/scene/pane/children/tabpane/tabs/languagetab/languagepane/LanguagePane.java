package com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.buttonbar.LanguageButtonBar;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.languagetab.languagepane.languagelistpane.LanguageListPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguagePane extends VBox {
    private LanguageListPane languageListPane = new LanguageListPane();
    private LanguageButtonBar buttonBar = new LanguageButtonBar();

    public LanguagePane() {
        VBox.setVgrow(this.languageListPane, Priority.ALWAYS);
        super.getChildren().addAll(this.languageListPane, this.buttonBar);
        super.setAlignment(Pos.CENTER);
    }

}