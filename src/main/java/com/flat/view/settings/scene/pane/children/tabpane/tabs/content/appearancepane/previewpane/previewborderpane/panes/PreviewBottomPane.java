package com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes;

import com.flat.models.fx.FxPreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.content.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewBottomPane extends ColorObserverPane {

    public PreviewBottomPane() {
        super(new BorderWidths(3, 0, 0, 0));
        super.setId("previewBottomPane");
        FxPreviewData.getPrimaryColor().addObserver(this);
        FxPreviewData.getBorderColor().addObserver(this);
    }

}