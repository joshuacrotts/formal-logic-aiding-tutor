package com.flat.view.main.panes.center.children.trees.parsetree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.trees.parsetree.listener.ParseTreePaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreePane extends Pane {

    public ParseTreePane() {
        this.initializeFx();
        Controller.getEVENT_BUS().addListener(new ParseTreePaneListener(this));
    }

    private void initializeFx () {
        this.onThisScroll();
    }

    private void onThisScroll () {
        super.setOnScroll(event -> {
            double newScale = super.getScaleX();
            if (event.getDeltaY() > 0)
                newScale += .2;
            else
                newScale -= .2;
            if (newScale > .3 && newScale < 4) {
                super.setScaleX(newScale);
                super.setScaleY(newScale);
            }
            event.consume();
        });
    }

}