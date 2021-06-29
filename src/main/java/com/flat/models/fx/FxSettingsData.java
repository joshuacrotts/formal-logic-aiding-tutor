package com.flat.models.fx;

import com.flat.models.json.settings.JsonSettings;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxSettingsData {
    private static Text title = new Text("Settings");
    private static Text apply = new Text("Apply");
    private static Text close = new Text("Close");
    private static Text appearance = new Text("Appearance");
    private static Text primaryColor = new Text("Primary Color:");
    private static Text secondaryColor = new Text("Secondary Color:");
    private static Text borderColor = new Text("Border Color:");
    private static Text language = new Text("Language");

    public static void injectData (JsonSettings _jsonSettings) {
        FxSettingsData.title.setText(_jsonSettings.getTitle().getString());
        FxSettingsData.apply.setText(_jsonSettings.getApply().getString());
        FxSettingsData.close.setText(_jsonSettings.getClose().getString());
        FxSettingsData.appearance.setText(_jsonSettings.getAppearanceTab().getAppearance().getString());
        FxSettingsData.primaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getPrimaryColor().getString());
        FxSettingsData.secondaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getSecondaryColor().getString());
        FxSettingsData.borderColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getBorderColor().getString());
        FxSettingsData.language.setText(_jsonSettings.getLanguageTab().getLanguage().getString());
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

    // Setters for object's attributes.
    public static void setTitle(Text title) {
        FxSettingsData.title = title;
    }

    public static void setApply(Text apply) {
        FxSettingsData.apply = apply;
    }

    public static void setClose(Text close) {
        FxSettingsData.close = close;
    }

    public static void setAppearance(Text appearance) {
        FxSettingsData.appearance = appearance;
    }

    public static void setPrimaryColor(Text primaryColor) {
        FxSettingsData.primaryColor = primaryColor;
    }

    public static void setSecondaryColor(Text secondaryColor) {
        FxSettingsData.secondaryColor = secondaryColor;
    }

    public static void setBorderColor(Text borderColor) {
        FxSettingsData.borderColor = borderColor;
    }

    public static void setLanguage(Text language) {
        FxSettingsData.language = language;
    }

}