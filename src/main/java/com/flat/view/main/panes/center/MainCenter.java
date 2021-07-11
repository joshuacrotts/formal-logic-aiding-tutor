package com.flat.view.main.panes.center;

import com.flat.view.main.panes.center.children.algorithmselection.AlgorithmSelectionPane;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainCenter extends VBox {
    private AlgorithmSelectionPane algorithmSelection = new AlgorithmSelectionPane();
    private Region emptyRegion = new Region();

    public MainCenter() {
        this.initializeFx();
    }

    public void initializeFx () {
        this.setThisFx();
        this.setEmptyRegionFx();
    }

    public void setThisFx () {
        super.setStyle("-fx-background-color: white");
        super.getChildren().addAll(this.algorithmSelection, this.emptyRegion);
        super.setAlignment(Pos.CENTER);
    }

    public void setEmptyRegionFx () {
        VBox.setVgrow(this.emptyRegion, Priority.ALWAYS);
    }

}