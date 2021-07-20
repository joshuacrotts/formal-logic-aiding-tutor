package com.flat.view.main.panes.top;

import com.flat.view.action.PopupMenuPane;
import com.flat.view.action.ResizePane;
import com.flat.view.main.panes.top.menupane.FlatMenuPane;
import com.flat.view.data.pane.PaneData;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainTop extends VBox {
    private final FlatMenuPane flatMenuPane = new FlatMenuPane();
    private final Region emptyRegion = new Region();
    private final PopupMenuPane popupPane = new PopupMenuPane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.BOTTOM, this.flatMenuPane);

    public MainTop() {
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx () {
        this.setThisFx();
        this.setEmptyRegionFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getTopProperty().borderProperty());
        super.getChildren().addAll(this.flatMenuPane, this.emptyRegion, this.popupPane.getParentPane());
        super.setAlignment(Pos.BASELINE_RIGHT);
    }

    private void onMouseExitedThis () {
        super.setOnMouseExited(event -> {
            if (event.getSceneY() <= 0)
                this.flatMenuPane.closeMenus();
        });
    }

    private void setEmptyRegionFx () {
        VBox.setVgrow(this.emptyRegion, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public FlatMenuPane getFlatMenuPane() {
        return flatMenuPane;
    }

}