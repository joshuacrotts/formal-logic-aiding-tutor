package com.flat.view.main.panes.center.children.practice.base;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.practice.base.bus.updates.AlgorithmPracticePaneUpdate;
import javafx.scene.layout.HBox;
import com.flat.view.main.panes.center.children.practice.base.bus.Practice;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class AlgorithmPracticePane extends HBox implements Practice {
    private boolean practiceResult = false;

    public AlgorithmPracticePane () {
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new AlgorithmPracticePaneUpdate(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.onThisScroll();
    }

    // Getters for object's attributes.
    public boolean isPracticeResult() {
        return practiceResult;
    }

    // Setters for object's attributes.
    public void setPracticeResult(boolean practiceResult) {
        this.practiceResult = practiceResult;
    }

        private void onThisScroll () {
        this.setOnScroll(event -> {
            double newScale = this.getScaleX();
            if (event.getDeltaY() > 0)
                newScale += .2;
            else
                newScale -= .2;
            if (newScale > .3 && newScale < 4) {
                this.setScaleX(newScale);
                this.setScaleY(newScale);
            }
            event.consume();
        });
    }

}