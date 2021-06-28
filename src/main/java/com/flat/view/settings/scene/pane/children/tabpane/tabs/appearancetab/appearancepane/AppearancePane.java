package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.ColorPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.PreviewPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AppearancePane extends HBox {
    private final ColorPane colorPane = new ColorPane();
    private final PreviewPane previewPane = new PreviewPane();

    public AppearancePane() {
        super.getChildren().addAll(this.colorPane, this.previewPane);
        super.setStyle("-fx-background-color: orange");
        super.setAlignment(Pos.CENTER);
    }

}