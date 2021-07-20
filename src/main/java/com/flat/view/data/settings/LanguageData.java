package com.flat.view.data.settings;

import com.flat.models.json.language.JsonLanguage;
import edu.emory.mathcs.backport.java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LanguageData {
    private final static ObservableList languages = FXCollections.observableArrayList();

    public static void injectData(JsonLanguage[] _languages) {
        LanguageData.languages.removeAll(LanguageData.languages);
        LanguageData.languages.addAll(Arrays.asList(_languages));
    }

    // Getters for object's attributes.
    public static ObservableList getLanguages() {
        return languages;
    }

}