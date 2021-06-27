package com.flat.models.fx.observables.color;

import java.util.Observable;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ObservableColor extends Observable {
    private Color color = new Color(0, 0, 0, 0);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        super.setChanged();
        this.color = color;
        super.notifyObservers();
    }

}