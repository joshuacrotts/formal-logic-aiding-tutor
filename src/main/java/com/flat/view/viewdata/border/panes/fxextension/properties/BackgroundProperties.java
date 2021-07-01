package com.flat.view.viewdata.border.panes.fxextension.properties;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BackgroundProperties {
    private Pane pane;
    private Color color;
    private CornerRadii cornerRadii;
    private Insets insets;

    public BackgroundProperties (Color _color, CornerRadii _cornerRadii, Insets _insets) {
        this.color = _color;
        this.cornerRadii = _cornerRadii;
        this.insets = _insets;
    }

    private void updateBackground () {
        if (this.pane != null)
            this.pane.setBackground(new Background(new BackgroundFill(this.color, this.cornerRadii, this.insets)));
    }

    // Getters for object's attributes.
    public Pane getPane() {
        return pane;
    }

    public Color getColor() {
        return color;
    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public Insets getInsets() {
        return insets;
    }

    // Setters for object's attributes.
    public void setPane(Pane pane) {
        this.pane = pane;
        this.updateBackground();
    }

    public void setColor(Color color) {
        this.color = color;
        this.updateBackground();
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
        this.updateBackground();
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
        this.updateBackground();
    }

}