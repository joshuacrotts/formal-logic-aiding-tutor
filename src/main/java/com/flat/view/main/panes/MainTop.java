package com.flat.view.main.panes;

import com.flat.view.action.PopupPane;
import com.flat.view.action.ResizePane;
import com.flat.view.main.menubar.FLATMenuBar;
import com.flat.view.viewdata.pane.PaneData;
import javafx.scene.layout.Pane;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainTop extends Pane {
    private final FLATMenuBar flatMenuBar = new FLATMenuBar();
    private final PopupPane popupPane = new PopupPane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.BOTTOM, flatMenuBar);

    public MainTop() {
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getTopProperty().borderProperty());
        super.getChildren().addAll(this.flatMenuBar, this.popupPane.getParentPane());
        this.initializeFx();
    }

    // Calls all FX property setters.
    private void initializeFx () {
        this.setPopupPaneFx();
        this.setFlatMenuBarFx();
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

    public void setFlatMenuBarFx () {
        this.flatMenuBar.backgroundProperty().bind(super.backgroundProperty());
    }

    // Getters for object's attributes.
    public FLATMenuBar getFlatMenuBar() {
        return flatMenuBar;
    }

    public PopupPane getPopupPane() {
        return popupPane;
    }

}