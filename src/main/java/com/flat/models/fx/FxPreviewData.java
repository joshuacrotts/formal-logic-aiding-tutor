package com.flat.models.fx;

import com.flat.models.fx.observables.color.extend.ObservableBorderColor;
import com.flat.models.fx.observables.color.extend.ObservablePrimaryColor;
import com.flat.models.fx.observables.color.extend.ObservableSecondaryColor;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FxPreviewData {
    private final static ObservablePrimaryColor primaryColor = new ObservablePrimaryColor();
    private final static ObservableSecondaryColor secondaryColor = new ObservableSecondaryColor();
    private final static ObservableBorderColor borderColor = new ObservableBorderColor();

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