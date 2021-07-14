package com.flat.view.main.panes.center;

import com.flat.view.main.panes.center.children.algorithmselection.AlgorithmSelectionPane;
import com.flat.view.main.panes.center.children.algorithmvisualselection.AlgorithmVisualSelectionPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainCenter extends VBox {
    private AlgorithmSelectionPane algorithmSelection = new AlgorithmSelectionPane();
    private Separator separator1 = new Separator();
    private AlgorithmVisualSelectionPane algorithmVisualSelection = new AlgorithmVisualSelectionPane();
    private Separator separator2 = new Separator();

    public MainCenter() {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setAlgorithmSelectionFx();
        this.setAlgorithmVisualSelectionFx();
    }

    private void setThisFx () {
        super.setStyle("-fx-background-color: white");
        super.getChildren().addAll(this.algorithmSelection, this.separator1, this.algorithmVisualSelection, this.separator2);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        this.onInvalidLocalBounds();
        this.separator1.setStyle("-fx-border-width: 1px");
        this.separator1.setStyle("-fx-border-color: black");
        this.separator2.setStyle("-fx-border-width: 1px");
        this.separator2.setStyle("-fx-border-color: black");
    }

    private void onInvalidLocalBounds () {
        super.boundsInLocalProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.getMinX() < 0 || newVal.getMinY() < 0)
                    super.setVisible(false);
                else
                    super.setVisible(true);
        });
    }

    private void setAlgorithmSelectionFx () {
        VBox.setMargin(this.algorithmSelection, new Insets(10, 0, 0, 0));
    }

    private void setAlgorithmVisualSelectionFx () {
        VBox.setMargin(this.algorithmVisualSelection, new Insets(0, 0, 0, 10));
    }

}