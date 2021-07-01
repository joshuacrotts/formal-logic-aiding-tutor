package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.colorpane.ColorPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.PreviewBorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewPane extends HBox {
    private final ColorPane colorPane = new ColorPane();
    private final PreviewBorderPane previewBorderPane = new PreviewBorderPane();

    public PreviewPane() {
        super.getChildren().addAll(this.colorPane, this.previewBorderPane);
        super.setAlignment(Pos.CENTER);
    }

}