package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.previewborderpane.panes.*;
import javafx.scene.layout.BorderPane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewBorderPane extends BorderPane {
    private final PreviewTopPane previewTopPane = new PreviewTopPane();
    private final PreviewRightPane previewRightPane = new PreviewRightPane();
    private final PreviewBottomPane previewBottomPane = new PreviewBottomPane();
    private final PreviewLeftPane previewLeftPane = new PreviewLeftPane();
    private final PreviewCenterPane previewCenterPane = new PreviewCenterPane();

    public PreviewBorderPane() {
        super.setMaxHeight(USE_PREF_SIZE);
        super.setId("previewBorderPane");
        super.setTop(this.previewTopPane);
        super.setRight(this.previewRightPane);
        super.setBottom(this.previewBottomPane);
        super.setLeft(this.previewLeftPane);
        super.setCenter(this.previewCenterPane);
    }

}