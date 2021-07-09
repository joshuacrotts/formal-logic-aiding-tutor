package com.flat.view.main.panes;

import com.flat.view.action.PopupMenuPane;
import com.flat.view.action.ResizePane;
import com.flat.view.main.menupane.FlatMenuPane;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainTop extends Pane {
    private final FlatMenuPane flatMenuPane = new FlatMenuPane();
    private final PopupMenuPane popupPane = new PopupMenuPane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.BOTTOM, this.flatMenuPane);

    public MainTop() {
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getTopProperty().borderProperty());
        super.getChildren().addAll(this.flatMenuPane, this.popupPane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx () {
        this.setPopupPaneFx();
    }

    // Setters for initial FX properties
    public void setPopupPaneFx () {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.popupPane.getParentPane().setMinWidth(newVal.doubleValue());
            this.popupPane.getParentPane().setMaxWidth(newVal.doubleValue());
        });
        super.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.popupPane.getParentPane().setLayoutY(newVal.doubleValue() - this.popupPane.getParentPane().getMaxHeight());
        });
    }

    // Getters for object's attributes.
    public FlatMenuPane getFlatMenuPane() {
        return flatMenuPane;
    }

}