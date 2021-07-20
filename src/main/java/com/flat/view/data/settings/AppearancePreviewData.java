package com.flat.view.data.settings;

import com.flat.view.data.settings.observables.color.extend.ObservableBorderColor;
import com.flat.view.data.settings.observables.color.extend.ObservablePrimaryColor;
import com.flat.view.data.settings.observables.color.extend.ObservableSecondaryColor;
import javafx.scene.paint.Color;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AppearancePreviewData {
    private final static ObservablePrimaryColor primaryColor = new ObservablePrimaryColor(Color.GRAY);
    private final static ObservableSecondaryColor secondaryColor = new ObservableSecondaryColor(Color.LIGHTGRAY);
    private final static ObservableBorderColor borderColor = new ObservableBorderColor(Color.BLACK);

    // Getters for object's attributes.
    public static ObservablePrimaryColor getPrimaryColor() {
        return primaryColor;
    }

    public static ObservableSecondaryColor getSecondaryColor() {
        return secondaryColor;
    }

    public static ObservableBorderColor getBorderColor() {
        return borderColor;
    }

}