package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.PreviewBottomPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.PreviewCenterPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.PreviewLeftPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.PreviewRightPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.PreviewTopPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewBorderPane extends BorderPane {
    private PreviewTopPane previewTopPane = new PreviewTopPane();
    private PreviewRightPane previewRightPane = new PreviewRightPane();
    private PreviewBottomPane previewBottomPane = new PreviewBottomPane();
    private PreviewLeftPane previewLeftPane = new PreviewLeftPane();
    private PreviewCenterPane previewCenterPane = new PreviewCenterPane();

    public PreviewBorderPane () {
        super.setId("previewBorderPane");
        super.setTop(this.previewTopPane);
        super.setRight(this.previewRightPane);
        super.setBottom(this.previewBottomPane);
        super.setLeft(this.previewLeftPane);
        super.setCenter(this.previewCenterPane);
    }

}