package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.truthselection;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.truthselection.buttons.PracticeFalseButton;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.truthselection.buttons.PracticeTrueButton;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeTruthSelectionPane extends HBox {
    private PracticeTrueButton trueButton = new PracticeTrueButton();
    private PracticeFalseButton falseButton = new PracticeFalseButton();
    private boolean truthValue = false;

    public PracticeTruthSelectionPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setTrueButtonFx();
        this.setFalseButtonFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.trueButton, this.falseButton);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
    }

    private void setTrueButtonFx () {
        this.setOnButtonClick(this.trueButton, true);
    }

    private void setFalseButtonFx () {
        this.setOnButtonClick(this.falseButton, false);
    }

    private void setOnButtonClick (Button _button, boolean _value) {
        _button.setOnAction(event -> {
            this.truthValue = _value;
        });
    }

    // Getters for object's attributes.
    public PracticeTrueButton getTrueButton() {
        return trueButton;
    }

    public PracticeFalseButton getFalseButton() {
        return falseButton;
    }

    public boolean getTruthValue() {
        return truthValue;
    }

    // Setters for object's attributes.
    public void setTrueButton(PracticeTrueButton trueButton) {
        this.trueButton = trueButton;
    }

    public void setFalseButton(PracticeFalseButton falseButton) {
        this.falseButton = falseButton;
    }

    public void setTruthValue(boolean truthValue) {
        this.truthValue = truthValue;
    }

}