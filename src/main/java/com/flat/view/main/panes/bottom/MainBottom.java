package com.flat.view.main.panes.bottom;

import com.flat.view.action.ResizePane;
import com.flat.view.main.panes.bottom.children.formulainput.FormulaInputPane;
import com.flat.view.viewdata.pane.PaneData;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainBottom extends VBox {
    private final ResizePane resizePane = new ResizePane(this, ResizePane.Orientation.VERTICAL, ResizePane.Side.TOP);
    private Region topEmptyRegion = new Region();
    private FormulaInputPane inputPane = new FormulaInputPane();
    private Region bottomEmptyRegion = new Region();

    public MainBottom () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setTopEmptyRegionFx();
        this.setInputPaneFx();
        this.setBottomEmptyRegionFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.resizePane.getParentPane(), this.topEmptyRegion, this.inputPane, this.bottomEmptyRegion);
        super.backgroundProperty().bind(PaneData.getBottomProperty().backgroundProperty());
        super.borderProperty().bind(PaneData.getBottomProperty().borderProperty());
        super.setAlignment(Pos.CENTER);
    }

    private void setTopEmptyRegionFx () {
        VBox.setVgrow(this.topEmptyRegion, Priority.ALWAYS);
    }

    private void setInputPaneFx () {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.inputPane.setMaxWidth(newVal.doubleValue() / 2);
        });
    }

    private void setBottomEmptyRegionFx () {
        VBox.setVgrow(this.bottomEmptyRegion, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public ResizePane getResizePane () {
        return resizePane;
    }

}