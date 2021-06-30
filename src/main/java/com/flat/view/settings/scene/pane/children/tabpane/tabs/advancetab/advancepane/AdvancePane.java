package com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.advancetab.advancepane.timeoutpane.TimeoutPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AdvancePane extends HBox {
    private TimeoutPane timeoutPane = new TimeoutPane();

    public AdvancePane () {
        super.getChildren().addAll(this.timeoutPane);
        super.setAlignment(Pos.CENTER);
    }

}