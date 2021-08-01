package com.flat.view.main.panes.center.children.practice.base.wff;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import javafx.scene.layout.HBox;
import com.flat.view.main.panes.center.children.practice.base.Practice;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class AlgorithmPracticePane extends HBox implements Practice {

    public AlgorithmPracticePane () {
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticePaneUpdate(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.onThisScroll();
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