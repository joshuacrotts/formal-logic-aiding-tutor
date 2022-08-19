package com.flat.view.main.panes.center.children.practice.naturaldeduction;

import com.flat.algorithms.NaturalDeductionProofVerifier;
import com.flat.algorithms.models.NDWffTree;
import com.flat.controller.Controller;
import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.practice.listener.events.PracticeResult;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.NaturalDeductionInputPane;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane.NDPracticeButtonPane;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.gridpane.NaturalDeductionGridPane;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.listener.NaturalDeductionPracticeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPractice extends VBox implements Practice {
    // Node Children
    private Text prove = new Text("Prove ");
    private NaturalDeductionGridPane proofPane = new NaturalDeductionGridPane();
    private NaturalDeductionInputPane ndInputPane = new NaturalDeductionInputPane();
    private NDPracticeButtonPane ndPracticeButtonPane = new NDPracticeButtonPane();
    // Latest user input wff.
    private ArrayList <WffTree> lineWff = null;
    // Wff for proof.
    private ArrayList <WffTree> proofWff = null;
    // Proof verifiers.
    public NaturalDeductionProofVerifier userProof = null;

    public NaturalDeductionPractice () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new NaturalDeductionPracticeListener(this));
        Controller.DATA_BUS.throwUpdate(new PracticePaneUpdate(this));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setWffInputFx();
        this.setStepInputFx();
        this.setLineInputFx();
        this.setEnterButtonFx();
        this.setResetButtonFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.prove, this.proofPane, this.ndInputPane, this.ndPracticeButtonPane);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(20);
    }

    private void setProveText () {
        for (int i = 0; i < this.userProof.getPremisesList().size() - 1; i++)
            this.prove.setText(this.prove.getText() + this.userProof.getPremisesList().get(i).getWffTree().getStringRep() + ", ");
        this.prove.setText(this.prove.getText() + this.userProof.getPremisesList().get(this.userProof.getPremisesList().size() - 1).getWffTree().getStringRep());
        this.prove.setText(this.prove.getText() + " therefore ");
        this.prove.setText(this.prove.getText() + this.userProof.getConclusionWff().getWffTree().getStringRep());
    }

    private void setEnterButtonFx () {
        this.setOnEnterButtonAction();
    }

    private void setOnEnterButtonAction () {
        this.ndPracticeButtonPane.getEnter().setOnAction(event -> {
            Controller.inputNDPracticeFormula(this.ndInputPane.getWffInput().getText());
        });
    }

    private void setResetButtonFx () {
        this.setOnResetButtonAction();
    }

    private void setOnResetButtonAction () {
        this.ndPracticeButtonPane.getReset().setOnAction(event -> {
            this.setProofWff(this.proofWff);
            Controller.DATA_BUS.throwUpdate(new PracticeResult(null));
        });
    }

    private void setWffInputFx () {
        this.onWffInputText();
    }

    private void onWffInputText () {
        this.ndInputPane.getWffInput().textProperty().addListener((obs, oldVal, newVal) -> {
            if ("".equals(newVal))
                this.ndPracticeButtonPane.getEnter().setDisable(true);
            else {
                if (this.ndInputPane.getStepInput().getSelectionModel().getSelectedItem() != null)
                    if (!this.ndInputPane.getLineInput().getText().isEmpty())
                        this.ndPracticeButtonPane.getEnter().setDisable(false);
            }
        });
    }

    private void setStepInputFx () {
        this.onStepInputSelection();
    }

    private void onStepInputSelection () {
        this.ndInputPane.getStepInput().getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null)
                this.ndPracticeButtonPane.getEnter().setDisable(true);
            else {
                if (!this.ndInputPane.getWffInput().getText().isEmpty())
                    if (!this.ndInputPane.getLineInput().getText().isEmpty())
                        this.ndPracticeButtonPane.getEnter().setDisable(false);
            }
        });
    }

    private void setLineInputFx () {
        this.onLineInputText();
    }

    private void onLineInputText () {
        this.ndInputPane.getLineInput().textProperty().addListener((obs, oldVal, newVal) -> {
            if ("".equals(newVal))
                this.ndPracticeButtonPane.getEnter().setDisable(true);
            else {
                if (this.ndInputPane.getStepInput().getSelectionModel().getSelectedItem() != null)
                        if (!this.ndInputPane.getWffInput().getText().isEmpty())
                            this.ndPracticeButtonPane.getEnter().setDisable(false);
            }
        });
    }

    public void addLine (NDWffTree _ndWff) {
        this.proofPane.addProofLine(_ndWff);
    }

    public void addInitialPremises () {
        this.userProof.getPremisesList().forEach(child -> {
            this.addLine(child);
        });
    }

    public void addLastPremise () {
        this.proofPane.addProofLine(this.userProof.getPremisesList().get(this.userProof.getPremisesList().size() - 1));
    }

    public void clearContent () {
        this.prove.setText("Prove ");
        this.proofPane.clear();
        this.ndInputPane.clearInput();
        this.userProof = null;
    }

    // Getters for object's attributes.
    public Text getProve() {
        return prove;
    }

    public NaturalDeductionGridPane getProofPane() {
        return proofPane;
    }

    public NaturalDeductionInputPane getNdInputPane() {
        return ndInputPane;
    }

    public ArrayList<WffTree> getLineWff() {
        return lineWff;
    }

    public ArrayList<WffTree> getProofWff() {
        return proofWff;
    }

    public NaturalDeductionProofVerifier getUserProof() {
        return userProof;
    }

    @Override
    public boolean getResult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Setters for object's attributes.
    public void setProve(Text prove) {
        this.prove = prove;
    }

    public void setProofPane(NaturalDeductionGridPane proofPane) {
        this.proofPane = proofPane;
    }

    public void setNdInputPane(NaturalDeductionInputPane ndInputPane) {
        this.ndInputPane = ndInputPane;
    }

    public void setLineWff(ArrayList<WffTree> lineWff) {
        this.lineWff = lineWff;
    }

    public void setProofWff(ArrayList<WffTree> proofWff) {
        this.proofWff = proofWff;
        this.clearContent();
        this.userProof = (new NaturalDeductionProofVerifier(this.getProofWff()));
        this.addInitialPremises();
        this.setProveText();
    }

    public void setUserProof(NaturalDeductionProofVerifier userProof) {
        this.userProof = userProof;
    }

    @Override
    public void setUserAnswer(Object _answer) {
        this.userProof = (NaturalDeductionProofVerifier) _answer;
    }


}