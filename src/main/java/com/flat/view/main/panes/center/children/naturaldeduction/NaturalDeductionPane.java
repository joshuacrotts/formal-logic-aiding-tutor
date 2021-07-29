package com.flat.view.main.panes.center.children.naturaldeduction;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.naturaldeduction.listener.NaturalDeductionPaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPane extends Pane {

    public NaturalDeductionPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new NaturalDeductionPaneListener(this));
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