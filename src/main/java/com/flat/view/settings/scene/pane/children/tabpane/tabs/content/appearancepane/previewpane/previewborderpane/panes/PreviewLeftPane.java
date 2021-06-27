package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes;

import com.flat.models.fx.FxPreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewLeftPane extends ColorObserverPane {

    public PreviewLeftPane() {
        super(new BorderWidths(0, 3, 0, 0));
        super.setId("previewLeftPane");
        FxPreviewData.getSecondaryColor().addObserver(this);
        FxPreviewData.getBorderColor().addObserver(this);
    }

}