package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.viewdata.PreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewBottomPane extends ColorObserverPane {

    public PreviewBottomPane() {
        super(new BorderWidths(3, 0, 0, 0));
        super.setId("previewBottomPane");
        PreviewData.getPrimaryColor().addObserver(this);
        PreviewData.getBorderColor().addObserver(this);
    }

}