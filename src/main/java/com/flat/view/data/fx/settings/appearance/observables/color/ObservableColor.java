package com.flat.view.data.fx.settings.appearance.observables.color;

import javafx.scene.paint.Color;

import java.util.Observable;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ObservableColor extends Observable {
    private Color color = new Color(0, 0, 0, 0);

    // Getters for object's attributes.
    public Color getColor() {
        return color;
    }

    // Setters for object's attributes.
    public void setColor(Color color) {
        super.setChanged();
        this.color = color;
        super.notifyObservers();
    }

}