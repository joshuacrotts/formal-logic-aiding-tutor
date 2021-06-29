package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.bordercolorpane;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.Label;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BorderColorLabel extends Label {

    public BorderColorLabel() {
        super.textProperty().bind(FxSettingsData.getBorderColor().textProperty());
    }

}