package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.buttonbar.AppearanceButtonBar;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.PreviewPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearancePane extends VBox {
    private final PreviewPane previewPane = new PreviewPane();
    private AppearanceButtonBar buttonBar = new AppearanceButtonBar();

    public AppearancePane() {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setPreviewPaneFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.previewPane, this.buttonBar);
        super.setAlignment(Pos.CENTER);
    }

    private void setPreviewPaneFx () {
        VBox.setVgrow(this.previewPane, Priority.ALWAYS);
    }

}