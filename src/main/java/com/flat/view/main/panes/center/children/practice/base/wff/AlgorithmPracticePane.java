package com.flat.view.main.panes.center.children.practice.base.wff;

import com.flat.controller.Controller;
import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import javafx.scene.layout.HBox;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.WffLayout;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class AlgorithmPracticePane extends HBox implements Practice {
    private WffTree wffTree = null;
    private WffLayout wffLayout = null;

    public AlgorithmPracticePane (WffTree _wffTree, WffLayout _wffLayout) {
        this.wffTree = _wffTree;
        this.wffLayout = _wffLayout;
        this.initializeFx();
        this.layoutWff();
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

    private void layoutWff () {
        this.wffLayout.getPieces().forEach(child -> {
            super.getChildren().add(child);
        });
    }

    // Getters for object's attributes.
    public WffTree getWffTree() {
        return wffTree;
    }

    public WffLayout getWffLayout() {
        return wffLayout;
    }

    // Setters for object's attributes.
    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

    public void setWffLayout(WffLayout wffLayout) {
        this.wffLayout = wffLayout;
    }

}