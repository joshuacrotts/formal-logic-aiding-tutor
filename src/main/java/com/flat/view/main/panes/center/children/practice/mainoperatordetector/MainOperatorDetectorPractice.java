package com.flat.view.main.panes.center.children.practice.mainoperatordetector;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.AlgorithmPracticePane;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.HighlightableWffPiece;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.WffLayout;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffPiece;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainOperatorDetectorPractice extends AlgorithmPracticePane {
    private WffPiece correctAnswer = null;
    private HighlightableWffPiece userAnswer = null;
    private WffLayout wffLayout = null;

    public MainOperatorDetectorPractice (WffTree _wffTree) {
        this.layoutWff(_wffTree);
        this.setHighlightableFx();
    }

    private void layoutWff (WffTree _wffTree) {
        this.wffLayout = new WffLayout(_wffTree);
        this.wffLayout.getPieces().forEach(child -> {
            super.getChildren().add(child);
            WffTree wff = ((WffPiece)child).getWffText().getWffTree();
            if (wff != null) {
                if (wff.isHighlighted())
                    this.correctAnswer = child;
            }
        });
    }

    private void setHighlightableFx () {
        for (WffPiece node : this.wffLayout.getHighlightablePieces()) {
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

}