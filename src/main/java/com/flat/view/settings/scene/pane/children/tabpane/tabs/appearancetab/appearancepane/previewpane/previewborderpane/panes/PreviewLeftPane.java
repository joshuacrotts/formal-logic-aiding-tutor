package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.viewdata.PreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewLeftPane extends ColorObserverPane {

    public PreviewLeftPane() {
        super(new BorderWidths(0, 3, 0, 0));
        super.setId("previewLeftPane");
        PreviewData.getSecondaryColor().addObserver(this);
        PreviewData.getBorderColor().addObserver(this);
    }

}