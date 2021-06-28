package com.flat.models.fx;

import com.flat.models.json.language.JsonLanguage;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FxLanguageData {
    private static List<JsonLanguage> languages = FXCollections.observableArrayList();

    public static void injectData(JsonLanguage[] _languages) {
        FxLanguageData.languages.removeAll(FxLanguageData.languages);
        FxLanguageData.languages.addAll(Arrays.asList(_languages));
    }

    // Getters for object's attributes.
    public static List<JsonLanguage> getLanguages() {
        return languages;
    }

    // Setters for object's attributes.
    public static void setLanguages(List<JsonLanguage> languages) {
        FxLanguageData.languages = languages;
    }

}