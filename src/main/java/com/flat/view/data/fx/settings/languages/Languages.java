package com.flat.view.data.fx.settings.languages;

import com.flat.models.json.language.JsonLanguage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Languages {
    private final ObservableList languages = FXCollections.observableArrayList();

    public Languages () {
    }

    // Getters for object's attributes.
    public ObservableList getLanguages () {
        return languages;
    }

    // Setters for object's attributes.
    public void setLanguages (JsonLanguage[] _languages) {
        this.languages.removeAll(this.languages);
        this.languages.addAll(Arrays.asList(_languages));
    }

}