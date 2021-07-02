package com.flat.view.main.panes;

import com.flat.view.action.ResizePane;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainBottom extends Pane {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.TOP);

    public MainBottom() {
        super.backgroundProperty().bind(PaneData.getBottomProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getBottomProperty().borderProperty());
        super.getChildren().add(this.resizePane.getParentPane());
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
        this.resizePane.getParentPane().setLayoutY(0);
    }

    // Getters for object's attributes.
    public ResizePane getResizePane() {
        return resizePane;
    }

}