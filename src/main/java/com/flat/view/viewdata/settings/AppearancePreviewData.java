package com.flat.view.viewdata.settings;

import com.flat.view.viewdata.observables.color.extend.ObservableBorderColor;
import com.flat.view.viewdata.observables.color.extend.ObservablePrimaryColor;
import com.flat.view.viewdata.observables.color.extend.ObservableSecondaryColor;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class AppearancePreviewData {
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