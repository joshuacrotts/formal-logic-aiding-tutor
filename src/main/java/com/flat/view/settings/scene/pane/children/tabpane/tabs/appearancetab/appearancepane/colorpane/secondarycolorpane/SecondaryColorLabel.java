package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.secondarycolorpane;

import com.flat.view.viewdata.SettingsData;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SecondaryColorLabel extends Label {

    public SecondaryColorLabel() {
        super.textProperty().bind(SettingsData.getSecondaryColor().textProperty());
    }

}