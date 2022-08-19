package com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.timeoutpane.children.base;

import com.flat.models.TimeoutManager;
import com.flat.tools.FLATUtils;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NumericTextField extends TextField {

    public NumericTextField () {
        this.setOnKeyPressed();
        this.setOnKeyTyped();
    }

    @Override
    public void paste () {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (this.validInput(Clipboard.getSystemClipboard().getString()))
            super.paste();
    }

    private void setOnKeyPressed () {
        super.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                if (super.getText(super.getCaretPosition(), super.getText().length()).startsWith("0"))
                    super.setText("");
            }
        });
    }

    private void setOnKeyTyped () {
        super.setOnKeyTyped(event -> {
            if (!this.validInput(event.getCharacter()))
                event.consume();
        });
    }

    private boolean validInput (String _string) {
        if (!FLATUtils.isNumeric(_string)) {
            return false;
        }
        String newValue;
        if(super.getSelectedText().isEmpty())
            newValue = super.getText(0, super.getCaretPosition())
                    + _string
                    + super.getText(super.getCaretPosition(), super.getText().length());
        else {
            newValue = super.getText(0, super.getSelection().getStart())
                    + _string
                    + super.getText(super.getSelection().getEnd(), super.getText().length());
        }
        return !(newValue.startsWith("0") || Integer.parseInt(newValue) > TimeoutManager.getMaxValue() || Integer.valueOf(newValue) <= TimeoutManager.getMinValue());
    }

}