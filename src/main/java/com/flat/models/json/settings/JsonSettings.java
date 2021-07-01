package com.flat.models.json.settings;

import com.flat.models.json.JsonString;
import com.flat.models.json.settings.tabs.advance.JsonAdvanceTab;
import com.flat.models.json.settings.tabs.appearance.JsonAppearanceTab;
import com.flat.models.json.settings.tabs.language.JsonLanguageTab;
import com.flat.models.translation.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonSettings extends Translatable {
    private JsonString title = new JsonString("Settings");
    private JsonString apply = new JsonString("Apply");
    private JsonString close = new JsonString("Close");
    private JsonAppearanceTab appearanceTab = new JsonAppearanceTab();
    private JsonLanguageTab languageTab = new JsonLanguageTab();
    private JsonAdvanceTab advanceTab = new JsonAdvanceTab();

    // Getters for object's attributes.
    public JsonString getTitle() {
        return title;
    }

    public JsonString getApply() {
        return apply;
    }

    public JsonString getClose() {
        return close;
    }

    public JsonAppearanceTab getAppearanceTab() {
        return appearanceTab;
    }

    public JsonLanguageTab getLanguageTab() {
        return languageTab;
    }

    public JsonAdvanceTab getAdvanceTab() {
        return advanceTab;
    }

    // Setters for object's attributes.
    public void setTitle(JsonString title) {
        this.title = title;
    }

    public void setApply(JsonString apply) {
        this.apply = apply;
    }

    public void setClose(JsonString close) {
        this.close = close;
    }

    public void setAppearanceTab(JsonAppearanceTab appearanceTab) {
        this.appearanceTab = appearanceTab;
    }

    public void setLanguageTab(JsonLanguageTab languageTab) {
        this.languageTab = languageTab;
    }

    public void setAdvanceTab(JsonAdvanceTab advanceTab) {
        this.advanceTab = advanceTab;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>() {{
            add(title);
            add(apply);
            add(close);
            addAll(appearanceTab.toTranslate());
            addAll(languageTab.toTranslate());
            addAll(advanceTab.toTranslate());
        }};
    }

}