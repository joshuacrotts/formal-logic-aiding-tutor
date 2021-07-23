package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PreviewBottomPane extends ColorObserverPane {

    public PreviewBottomPane() {
        super(new BorderWidths(3, 0, 0, 0));
        super.setId("previewBottomPane");
        AppearancePreviewData.getPrimaryColor().addObserver(this);
        AppearancePreviewData.getBorderColor().addObserver(this);
    }

}