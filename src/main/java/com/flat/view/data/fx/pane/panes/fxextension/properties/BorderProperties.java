package com.flat.view.data.fx.pane.panes.fxextension.properties;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BorderProperties {
    private Pane pane;
    private Color borderColor = Color.BLACK;
    private BorderStrokeStyle borderStrokeStyle = BorderStrokeStyle.SOLID;
    private CornerRadii cornerRadii = CornerRadii.EMPTY;
    private BorderWidths borderWidths = BorderWidths.EMPTY;

    public BorderProperties (Pane _pane) {
        this.pane = _pane;
    }

    public BorderProperties (Pane _pane, Color _borderColor, BorderStrokeStyle _borderStrokeStyle, CornerRadii _cornerRadii,  BorderWidths _borderWidths) {
        this.pane = _pane;
        this.borderColor = _borderColor;
        this.borderStrokeStyle = _borderStrokeStyle;
        this.cornerRadii = _cornerRadii;
        this.borderWidths = _borderWidths;
        this.updateBorder();


    }

    private void updateBorder () {
        this.pane.setBorder(new Border(new BorderStroke(this.borderColor, this.borderStrokeStyle, this.cornerRadii, this.borderWidths)));
    }

    // Getters for object's attributes.
    public Pane getPane() {
        return pane;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public BorderStrokeStyle getBorderStrokeStyle() {
        return borderStrokeStyle;
    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public BorderWidths getBorderWidths() {
        return borderWidths;
    }

    // Setters for object's attributes.
    public void setPane(Pane pane) {
        this.pane = pane;
        this.updateBorder();
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        this.updateBorder();
    }

    public void setBorderStrokeStyle(BorderStrokeStyle borderStrokeStyle) {
        this.borderStrokeStyle = borderStrokeStyle;
        this.updateBorder();
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
        this.updateBorder();
    }

    public void setBorderWidths(BorderWidths borderWidths) {
        this.borderWidths = borderWidths;
        this.updateBorder();
    }

}