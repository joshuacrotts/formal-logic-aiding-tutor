package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.primarycolorpane;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.Label;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryColorLabel extends Label {

    public PrimaryColorLabel () {
        super.textProperty().bind(FxSettingsData.getPrimaryColor().textProperty());
    }

}