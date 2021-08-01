package com.flat.view.main.panes.right.children;

import com.flat.view.main.panes.right.children.selection.RightSelectionPane;
import com.flat.view.main.panes.right.children.top.practicetoggle.PracticeToggleWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RightVBoxWrapper extends VBox {
    private PracticeToggleWrapper toggleWrapper = new PracticeToggleWrapper();
    private Separator toggleSeparator = new Separator(Orientation.HORIZONTAL);
    private RightSelectionPane selectionPane = new RightSelectionPane();

    public RightVBoxWrapper () {
        this.initializeFx();
        this.setToggleWrapperFx();
        this.setSelectionPaneFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleWrapper, this.toggleSeparator, this.selectionPane);
        super.setAlignment(Pos.TOP_CENTER);
        super.setMinWidth(0);
    }

    private void setToggleWrapperFx () {
        VBox.setMargin(this.toggleWrapper, new Insets(10));
    }

    private void setSelectionPaneFx () {
        VBox.setVgrow(this.selectionPane, Priority.ALWAYS);
    }

}