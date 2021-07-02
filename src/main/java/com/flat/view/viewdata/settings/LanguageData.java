package com.flat.view.viewdata.settings;

import com.flat.models.json.language.JsonLanguage;
import edu.emory.mathcs.backport.java.util.Arrays;
import javafx.collections.FXCollections;

import java.util.List;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LanguageData {
    private final static List<JsonLanguage> languages = FXCollections.observableArrayList();

    public static void injectData(JsonLanguage[] _languages) {
        LanguageData.languages.removeAll(LanguageData.languages);
        LanguageData.languages.addAll(Arrays.asList(_languages));
    }

    // Getters for object's attributes.
    public static List<JsonLanguage> getLanguages() {
        return languages;
    }

}