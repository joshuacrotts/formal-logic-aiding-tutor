package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class HighlightableWffPiece extends WffPiece {
    private SimpleBooleanProperty selected = new SimpleBooleanProperty(false);

    public HighlightableWffPiece (WffText _wffText) {
        super(_wffText);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getStyleClass().clear();
        super.getStyleClass().add("highlightableWffPiece");
        this.setOnSelected();
    }

    private void setOnSelected () {
        this.selected.addListener(event -> {
            super.pseudoClassStateChanged(PseudoClass.getPseudoClass("selected"), this.selected.getValue());
        });
    }

    // Getters for object's attributes.
    public SimpleBooleanProperty getSelected() {
        return selected;
    }

    // Setters for object's attributes.
    public void setSelected(boolean _selected) {
        this.selected.set(_selected);
    }

}