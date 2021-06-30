package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.buttonbar.button;

import com.flat.models.fx.FxSettingsData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvanceApplyButton extends Button {

    public AdvanceApplyButton () {
        super.textProperty().bind(FxSettingsData.getApply().textProperty());
    }

}