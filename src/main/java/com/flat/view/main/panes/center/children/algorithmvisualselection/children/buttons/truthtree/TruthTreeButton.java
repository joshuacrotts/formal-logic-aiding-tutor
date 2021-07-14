package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree;

import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreeButton extends Button {

    public TruthTreeButton () {
        super.setText("Truth Tree");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
    }

}