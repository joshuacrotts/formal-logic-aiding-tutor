package com.flat.view.main.panes.center.children.practice.mainoperatordetector;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.wff.AlgorithmPracticePane;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.WffHighlightableOperatorLayout;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.HighlightableWffPiece;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffPiece;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainOperatorDetectorPractice extends AlgorithmPracticePane {
    private WffPiece correctAnswer = null;
    private HighlightableWffPiece userAnswer = null;

    public MainOperatorDetectorPractice (WffTree _wffTree) {
        super(_wffTree, new WffHighlightableOperatorLayout(_wffTree));
        this.determineCorrectAnswer();
        this.setHighlightableFx();
    }

    private void determineCorrectAnswer () {
        super.getWffLayout().getPieces().forEach(child -> {
            WffTree wff = ((WffPiece)child).getWffText().getWffTree();
            if (wff != null) {
                if (wff.isHighlighted())
                    this.correctAnswer = child;
            }
        });
    }

    private void setHighlightableFx () {
        for (WffPiece node : ((WffHighlightableOperatorLayout)super.getWffLayout()).getHighlightablePieces()) {
            ((HighlightableWffPiece)node).setOnMousePressed(event -> {
                if (this.userAnswer != null)
                    this.userAnswer.setSelected(false);
                ((HighlightableWffPiece)node).setSelected(true);
                this.userAnswer = ((HighlightableWffPiece)node);
            });
        }
    }

    @Override
    public boolean getResult() {
        return this.correctAnswer.equals(this.userAnswer);
    }

    @Override
    public void setUserAnswer(Object _answer) {
        this.userAnswer = (HighlightableWffPiece) _answer;
    }

}