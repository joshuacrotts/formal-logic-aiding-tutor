package com.flat.view.main.panes.center.children.practice.truthtable.children.children;

import javafx.css.PseudoClass;
import javafx.scene.control.TextField;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTablePracticeTextField extends TextField {
    private boolean correctAnswer;

    public TruthTablePracticeTextField (boolean _correctAnswer) {
        this.correctAnswer = _correctAnswer;
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setMinWidth(50);
        super.setMaxWidth(50);
        super.getStyleClass().add("practiceTextField");
    }

    public boolean checkAnswer () {
        boolean returnValue;
        if (this.correctAnswer == true)
            returnValue = "t".equals(super.getText().toLowerCase()) || "true".equals(super.getText().toLowerCase());
        else
            returnValue = "f".equals(super.getText().toLowerCase()) || "false".equals(super.getText().toLowerCase());
        this.setCheckAnswerFx(returnValue);
        return returnValue;
    }

    private void setCheckAnswerFx (boolean _true) {
        super.pseudoClassStateChanged(PseudoClass.getPseudoClass("correct"), _true);
        super.pseudoClassStateChanged(PseudoClass.getPseudoClass("incorrect"), !_true);
    }

}