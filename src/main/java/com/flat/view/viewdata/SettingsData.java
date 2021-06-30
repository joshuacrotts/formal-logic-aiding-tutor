package com.flat.view.viewdata;

import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.settings.JsonSettings;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsData {
    private final static Text title = new Text("Settings");
    private final static Text apply = new Text("Apply");
    private final static Text close = new Text("Close");
    private final static Text appearance = new Text("Appearance");
    private final static Text primaryColor = new Text("Primary Color:");
    private final static Text secondaryColor = new Text("Secondary Color:");
    private final static Text borderColor = new Text("Border Color:");
    private final static Text language = new Text("Language");
    private final static Text predicateNDVTimeout = new Text("100");
    private final static Text predicateTruthTreeTimeout = new Text("100");
    private final static Text propositionalNDVTimeout = new Text("100");
    private final static Text propositionalTruthTreeTimeout = new Text("100");
    private final static Text truthTableTimeout = new Text("100");

    public static void injectData(JsonLanguage _jsonLanguage, JsonSettings _jsonSettings) {
        title.setText(_jsonSettings.getTitle().getString());
        apply.setText(_jsonSettings.getApply().getString());
        close.setText(_jsonSettings.getClose().getString());
        appearance.setText(_jsonSettings.getAppearanceTab().getAppearance().getString());
        primaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getPrimaryColor().getString());
        secondaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getSecondaryColor().getString());
        borderColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getBorderColor().getString());
        language.setText(_jsonSettings.getLanguageTab().getLanguage().getString());
    }

    // Getters for object's attributes.
    public static Text getTitle() {
        return title;
    }

    public static Text getApply() {
        return apply;
    }

    public static Text getClose() {
        return close;
    }

    public static Text getAppearance() {
        return appearance;
    }

    public static Text getPrimaryColor() {
        return primaryColor;
    }

    public static Text getSecondaryColor() {
        return secondaryColor;
    }

    public static Text getBorderColor() {
        return borderColor;
    }

    public static Text getLanguage() {
        return language;
    }

    public static Text getPredicateNDVTimeout() {
        return predicateNDVTimeout;
    }

    public static Text getPredicateTruthTreeTimeout() {
        return predicateTruthTreeTimeout;
    }

    public static Text getPropositionalNDVTimeout() {
        return propositionalNDVTimeout;
    }

    public static Text getPropositionalTruthTreeTimeout() {
        return propositionalTruthTreeTimeout;
    }

    public static Text getTruthTableTimeout() {
        return truthTableTimeout;
    }

}