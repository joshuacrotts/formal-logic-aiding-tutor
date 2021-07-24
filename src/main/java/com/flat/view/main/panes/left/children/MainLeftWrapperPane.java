package com.flat.view.main.panes.left.children;

import com.flat.view.main.panes.left.children.logicsymbolspane.LogicSymbolsPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainLeftWrapperPane extends VBox {
    private LogicSymbolsPane symbolsPane = new LogicSymbolsPane();

    public MainLeftWrapperPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setSymbolsPaneFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.symbolsPane);
        super.setAlignment(Pos.CENTER);
        super.setMinWidth(0);
    }

    private void setSymbolsPaneFx () {
        VBox.setMargin(this.symbolsPane, new Insets(10));
    }
}