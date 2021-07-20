package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.data.settings.AppearancePreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewRightPane extends ColorObserverPane {

    public PreviewRightPane() {
        super(new BorderWidths(0, 0, 0, 3));
        super.setId("previewRightPane");
        AppearancePreviewData.getSecondaryColor().addObserver(this);
        AppearancePreviewData.getBorderColor().addObserver(this);
    }

}