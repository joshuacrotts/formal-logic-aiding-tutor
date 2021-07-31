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
        Controller.DATA_BUS.throwUpdate(new AlgorithmPracticePaneUpdate(this));
    }

    // Getters for object's attributes.
    public boolean isPracticeResult() {
        return practiceResult;
    }

    // Setters for object's attributes.
    public void setPracticeResult(boolean practiceResult) {
        this.practiceResult = practiceResult;
    }

}