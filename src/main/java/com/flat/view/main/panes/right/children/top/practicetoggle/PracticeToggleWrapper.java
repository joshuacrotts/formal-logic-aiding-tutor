package com.flat.view.main.panes.right.children.top.practicetoggle;

import com.flat.view.main.panes.right.children.top.practicetoggle.pane.PracticeModeTogglePane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeToggleWrapper extends HBox {
    private double minDisplayWidth = 140;
    private PracticeModeToggleText toggleText = new PracticeModeToggleText();
    private PracticeModeTogglePane togglePane = new PracticeModeTogglePane();

    public PracticeToggleWrapper () {
        this.initializeFx();
        this.setTogglePaneFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleText, this.togglePane);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        this.onWidthProperty();
        super.setMinWidth(0);
    }

    private void setTogglePaneFx () {
        HBox.setHgrow(this.togglePane, Priority.ALWAYS);
    }

    private void onWidthProperty () {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() < this.minDisplayWidth)
                super.setVisible(false);
            else
                super.setVisible(true);
        });
    }

}