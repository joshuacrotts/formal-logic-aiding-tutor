package com.flat.view.main.panes.center.children.algorithmvisualselection;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.naturaldeduction.NaturalDeductionButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.parsetree.ParseTreeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.practice.PracticeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtable.TruthTableButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.buttons.truthtree.TruthTreeButton;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.AlgorithmResultPane;
import com.flat.view.main.panes.center.children.algorithmvisualselection.listener.AlgorithmVisualSelectionPaneListener;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmVisualSelectionPane extends HBox {
    private TruthTreeButton truthTreeButton = new TruthTreeButton();
    private ParseTreeButton parseTreeButton = new ParseTreeButton();
    private TruthTableButton truthTableButton = new TruthTableButton();
    private NaturalDeductionButton naturalDeductionButton = new NaturalDeductionButton();
    private PracticeButton practiceButton = new PracticeButton();
    private AlgorithmVisualSelectionPaneListener listener;

    public AlgorithmVisualSelectionPane () {
        this.initializeFx();
        this.listener = new AlgorithmVisualSelectionPaneListener(this);
        Controller.EVENT_BUS.addListener(this.listener);
        Controller.DATA_BUS.addListener(this.listener);
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    super.getChildren().addAll(this.truthTreeButton, this.parseTreeButton, this.truthTableButton, this.naturalDeductionButton, this.practiceButton, new AlgorithmResultPane());
    super.setAlignment(Pos.CENTER_LEFT);
    super.setSpacing(10);
    }

    // Getters for object's attributes.
    public TruthTreeButton getTruthTreeButton() {
        return truthTreeButton;
    }

    public ParseTreeButton getParseTreeButton() {
        return parseTreeButton;
    }

    public TruthTableButton getTruthTableButton() {
        return truthTableButton;
    }

    public NaturalDeductionButton getNaturalDeductionButton() {
        return naturalDeductionButton;
    }

    public PracticeButton getPracticeButton() {
        return practiceButton;
    }

    // Setters for object's attributes.
    public void setTruthTreeButton(TruthTreeButton truthTreeButton) {
        this.truthTreeButton = truthTreeButton;
    }

    public void setParseTreeButton(ParseTreeButton parseTreeButton) {
        this.parseTreeButton = parseTreeButton;
    }

    public void setTruthTableButton(TruthTableButton truthTableButton) {
        this.truthTableButton = truthTableButton;
    }

    public void setNaturalDeductionButton(NaturalDeductionButton naturalDeductionButton) {
        this.naturalDeductionButton = naturalDeductionButton;
    }

    public void setPracticeButton(PracticeButton practiceButton) {
        this.practiceButton = practiceButton;
    }

}