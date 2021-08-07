package com.flat.view.main.panes.center.children.practice.base.truthtree.nodes.children;

import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNodePracticeText extends Text {
    private Boolean isOpen = null;
    private Boolean userAnswer = null;

    public TreeNodePracticeText (boolean _isOpen) {
        super("?");
        this.isOpen = _isOpen;
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.setThisOnMousePressed();
    }

    private void setThisOnMousePressed () {
        super.setOnMousePressed(event -> {
            System.out.println("is pressed");
            if (userAnswer == null)
                userAnswer = false;
            else
                userAnswer ^= true;
            super.setText(this.userAnswer ? "\u2715" : "Open");
        });
    }

    public boolean checkAnswer () {
        if (this.isOpen == null || this.userAnswer == null)
            return false;
        else
            return this.isOpen.booleanValue() == this.userAnswer.booleanValue();
    }

}