package com.flat.view.main;

import com.flat.view.action.ResizePane;
import com.flat.view.menubar.FLATMenuBar;
import com.flat.view.viewdata.border.BorderData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainTop {
    private final ResizePane resizePane;
    private Pane parentPane = new Pane();

    public MainTop() {
        this.parentPane.backgroundProperty().bind(BorderData.getTopProperty().backgroundProperty());
        this.parentPane.borderProperty().bind(BorderData.getTopProperty().borderProperty());
        this.resizePane = new ResizePane(this.parentPane, ResizePane.Orientation.VERTICAL, ResizePane.Side.BOTTOM);
        this.parentPane.getChildren().add(new FLATMenuBar());
        this.parentPane.getChildren().add(this.resizePane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    public void initializeFx() {
        this.setResizePaneFx();
    }

    // Setters for initial FX properties
    public void setResizePaneFx() {
        this.parentPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setMinWidth(newVal.doubleValue());
            this.resizePane.getParentPane().setMaxWidth(newVal.doubleValue());
        });
        this.parentPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.resizePane.getParentPane().setLayoutY(newVal.doubleValue() - this.resizePane.getParentPane().getMaxHeight());
        });
    }

    // Getters for object's attributes.
    public Pane getParentPane() {
        return this.parentPane;
    }

    // Setters for object's attributes.
    public void setParentPane(Pane parentPane) {
        this.parentPane = parentPane;
    }

}