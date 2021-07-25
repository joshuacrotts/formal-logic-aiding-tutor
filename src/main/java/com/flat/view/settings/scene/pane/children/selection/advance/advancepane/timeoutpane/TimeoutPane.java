package com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane;

import com.flat.view.settings.scene.pane.children.selection.advance.advancepane.timeoutpane.children.TimeoutFieldsPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TimeoutPane extends VBox {
    private TimeoutFieldsPane timeoutFieldsPane = new TimeoutFieldsPane();

    public TimeoutPane () {
        super.getChildren().addAll(this.timeoutFieldsPane);
        super.setAlignment(Pos.CENTER);
    }

}