package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.buttonbar.AppearanceButtonBar;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.PreviewPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AppearancePane extends VBox {
    private final PreviewPane previewPane = new PreviewPane();
    private AppearanceButtonBar buttonBar = new AppearanceButtonBar();

    public AppearancePane() {
        VBox.setVgrow(this, Priority.NEVER);
        VBox.setVgrow(this.previewPane, Priority.ALWAYS);
        super.getChildren().addAll(this.previewPane, this.buttonBar);
        super.setAlignment(Pos.CENTER);
    }

}