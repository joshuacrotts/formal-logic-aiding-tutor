package com.flat.view.main.panes.right.children.selection.children.selections;

import com.flat.view.main.panes.right.children.selection.children.selections.buttons.practice.PracticeSelectionButton;
import com.flat.view.main.panes.right.children.selection.children.selections.buttons.rulesaxioms.RulesAxiomsSelectionButton;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RightSelectionHBox extends HBox {
    private double minDisplayWidth = 185;

    public RightSelectionHBox () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setChildrenFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(new RulesAxiomsSelectionButton(), new PracticeSelectionButton());
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        this.onWidthProperty();
    }

    private void setChildrenFx () {
        super.getChildren().forEach(child -> {
            HBox.setHgrow(child, Priority.ALWAYS);
        });
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