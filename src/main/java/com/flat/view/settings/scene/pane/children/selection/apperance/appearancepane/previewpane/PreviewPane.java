package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.ColorPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.PreviewBorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewPane extends HBox {
    private final ColorPane colorPane = new ColorPane();
    private final PreviewBorderPane previewBorderPane = new PreviewBorderPane();

    public PreviewPane() {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.colorPane, this.previewBorderPane);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
    }

}