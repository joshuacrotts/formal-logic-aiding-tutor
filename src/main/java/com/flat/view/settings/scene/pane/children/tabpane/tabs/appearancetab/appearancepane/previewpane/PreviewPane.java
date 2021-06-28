package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.PreviewBorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewPane extends VBox {
    private final PreviewBorderPane previewBorderPane = new PreviewBorderPane();

    public PreviewPane() {
        super.getChildren().add(this.previewBorderPane);
        super.setAlignment(Pos.CENTER);
    }

}