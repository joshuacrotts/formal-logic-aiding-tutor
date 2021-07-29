package com.flat.view.main.panes.center.children.truthtable;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.truthtable.listener.TruthTablePaneListener;
import javafx.scene.layout.HBox;

/**
 *
 * @author christopherbrantley
 */
public class TruthTablePane extends HBox {

    public TruthTablePane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new TruthTablePaneListener(this));
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