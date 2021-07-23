package com.flat.view.main.panes.center;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmselection.AlgorithmSelectionPane;
import com.flat.view.main.panes.center.children.algorithmvisualselection.AlgorithmVisualSelectionPane;
import com.flat.view.main.panes.center.children.trees.parsetree.ParseTreePane;
import com.flat.view.main.panes.center.children.trees.truthtree.TruthTreePane;
import com.flat.view.main.panes.center.children.truthtable.TruthTablePane;
import com.flat.view.main.panes.center.listener.MainCenterListener;
import com.flat.view.main.panes.center.logicvisualpane.LogicVisualPane;
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
    private LogicVisualPane logicVisualPane = new LogicVisualPane();
    private TruthTreePane truthTreePane = new TruthTreePane();
    private ParseTreePane parseTreePane = new ParseTreePane();
    private TruthTablePane truthTablePane = new TruthTablePane();

    public MainCenter() {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new MainCenterListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setAlgorithmSelectionFx();
        this.setAlgorithmVisualSelectionFx();
    }

    private void setThisFx () {
        super.setStyle("-fx-background-color: white");
        super.getChildren().addAll(this.algorithmSelection, this.separator1, this.algorithmVisualSelection, this.separator2, this.logicVisualPane);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        this.onInvalidLocalBounds();
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

    // Getters for object's attributes.
    public LogicVisualPane getLogicVisualPane() {
        return logicVisualPane;
    }

    public TruthTreePane getTruthTreePane() {
        return truthTreePane;
    }

    public ParseTreePane getParseTreePane() {
        return parseTreePane;
    }

    public TruthTablePane getTruthTablePane() {
        return truthTablePane;
    }

}