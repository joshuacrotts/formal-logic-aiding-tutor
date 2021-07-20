package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.data.fx.settings.AppearancePreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewTopPane extends ColorObserverPane {

    public PreviewTopPane() {
        super(new BorderWidths(0, 0, 3, 0));
        super.setId("previewTopPane");
        AppearancePreviewData.getPrimaryColor().addObserver(this);
        AppearancePreviewData.getBorderColor().addObserver(this);
    }

}