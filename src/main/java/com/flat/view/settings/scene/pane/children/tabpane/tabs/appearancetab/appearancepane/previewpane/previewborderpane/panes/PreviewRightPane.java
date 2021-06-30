package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes;

import com.flat.view.viewdata.PreviewData;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer.ColorObserverPane;
import javafx.scene.layout.BorderWidths;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PreviewRightPane extends ColorObserverPane {

    public PreviewRightPane() {
        super(new BorderWidths(0, 0, 0, 3));
        super.setId("previewRightPane");
        PreviewData.getSecondaryColor().addObserver(this);
        PreviewData.getBorderColor().addObserver(this);
    }

}