package com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children;

import com.flat.view.main.panes.center.children.practice.mainoperatordetector.layout.children.WffText;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class WffPiece extends VBox {
    private WffText wffText;

    public WffPiece (WffText _wffText) {
        this.wffText = _wffText;
        this.initializeFx();
    }

    private void initializeFx () {
        super.getChildren().add(this.wffText);
        this.setThisFx();
    }

    private void setThisFx () {
        super.setAlignment(Pos.CENTER);
    }

    // Getters for object's attributes.
    public WffText getWffText() {
        return wffText;
    }

    // Setters for object's attributes.
    public void setWffText(WffText wffText) {
        this.wffText = wffText;
    }

}