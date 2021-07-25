package com.flat.view.settings.scene.pane.children.selection.advance.advancepane;

import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.buttonbar.AdvanceButtonBar;
import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.TimeoutPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AdvancePane extends VBox {
    private TimeoutPane timeoutPane = new TimeoutPane();
    private AdvanceButtonBar buttonBar = new AdvanceButtonBar();

    public AdvancePane () {
        VBox.setVgrow(this.timeoutPane, Priority.ALWAYS);
        super.getChildren().addAll(this.timeoutPane, this.buttonBar);
        super.setAlignment(Pos.CENTER);
    }

}