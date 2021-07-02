package com.flat.view.viewdata.pane.fxextension.properties;

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
    private Color color = Color.WHITE;
    private CornerRadii cornerRadii = CornerRadii.EMPTY;
    private Insets insets = Insets.EMPTY;

    public BackgroundProperties (Pane _pane) {
        this.pane = _pane;
    }

    public BackgroundProperties (Pane _pane, Color _color, CornerRadii _cornerRadii, Insets _insets) {
        this.pane = _pane;
        this.color = _color;
        this.cornerRadii = _cornerRadii;
        this.insets = _insets;
    }

    private void updateBackground () {
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