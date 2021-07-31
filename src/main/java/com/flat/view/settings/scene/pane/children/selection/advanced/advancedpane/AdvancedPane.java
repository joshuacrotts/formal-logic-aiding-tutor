package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane;

import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.buttonbar.AdvancedButtonBar;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.TimeoutPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvancedPane extends VBox {
    private TimeoutPane timeoutPane = new TimeoutPane();
    private AdvancedButtonBar buttonBar = new AdvancedButtonBar();

    public AdvancedPane () {
        VBox.setVgrow(this.timeoutPane, Priority.ALWAYS);
        super.getChildren().addAll(this.timeoutPane, this.buttonBar);
        super.setAlignment(Pos.CENTER);
    }

}