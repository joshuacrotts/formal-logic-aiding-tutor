package com.flat.view.data.fx;

import com.flat.view.data.fx.algorithms.AvailableAlgorithms;
import com.flat.view.data.fx.settings.languages.Languages;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxData {
    private static FxData instance = null;
    private AvailableAlgorithms availableAlgorithms = new AvailableAlgorithms();
    private Languages languages = new Languages();

    private FxData () {
    }

    public static FxData getInstance () {
        if (instance == null)
            instance = new FxData();
        return instance;
    }

    // Getters for object's attributes.
    public AvailableAlgorithms getAvailableAlgorithms() {
        return availableAlgorithms;
    }

    public Languages getLanguages() {
        return languages;
    }

    // Setters for object's attributes.
    public void setAvailableAlgorithms(AvailableAlgorithms availableAlgorithms) {
        this.availableAlgorithms = availableAlgorithms;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

}