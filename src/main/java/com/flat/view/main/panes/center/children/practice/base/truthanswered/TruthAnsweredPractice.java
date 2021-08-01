package com.flat.view.main.panes.center.children.practice.base.truthanswered;

import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.wff.AlgorithmPracticePane;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.WffPlainLayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class TruthAnsweredPractice extends AlgorithmPracticePane {
    private boolean correctAnswer;
    private Boolean userAnswer = null;

    public TruthAnsweredPractice(boolean _correctAnswer, WffTree _wffTree) {
        super(_wffTree,  new WffPlainLayout(_wffTree));
        this.correctAnswer = _correctAnswer;
    }

    // Getters for object's attributes.
    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public Boolean getUserAnswer() {
        return userAnswer;
    }

    @Override
    public boolean getResult () {
        return this.correctAnswer == userAnswer;
    }

    // Setters for object's attributes.
    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void setUserAnswer(Object _answer) {
        this.userAnswer = (Boolean) _answer;
    }

}