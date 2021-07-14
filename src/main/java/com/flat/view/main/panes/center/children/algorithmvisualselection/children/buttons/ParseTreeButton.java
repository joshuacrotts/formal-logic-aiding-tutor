package com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons;

import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreeButton extends Button {

    public ParseTreeButton () {
        super.setText("Parse Tree");
        super.backgroundProperty().bind(PaneData.getPrimaryButtonProperty().backgroundProperty());
    }

}