package com.flat.view.main.panes;

import com.flat.view.action.ResizePane;
import com.flat.view.menubar.FLATMenuBar;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainTop extends Pane {
    private final FLATMenuBar flatMenuBar = new FLATMenuBar();
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.BOTTOM);

    public MainTop() {
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getTopProperty().borderProperty());
        super.getChildren().addAll(this.flatMenuBar, this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx() {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    public void setResizePaneFx() {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setMinWidth(newVal.doubleValue());
            this.resizePane.getParentPane().setMaxWidth(newVal.doubleValue());
        });
        super.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setLayoutY(newVal.doubleValue() - this.resizePane.getParentPane().getMaxHeight());
        });
    }

    // Getters for object's attributes.
    public FLATMenuBar getFlatMenuBar() {
        return flatMenuBar;
    }

    public ResizePane getResizePane() {
        return resizePane;
    }

}