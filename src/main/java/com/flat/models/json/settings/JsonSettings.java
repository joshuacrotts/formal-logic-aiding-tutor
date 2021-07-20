package com.flat.models.json.settings;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.settings.tabs.advance.JsonAdvanceTab;
import com.flat.models.json.settings.tabs.appearance.JsonAppearanceTab;
import com.flat.models.json.settings.tabs.language.JsonLanguageTab;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonSettings extends Translatable {

    public enum Keys implements JsonKey {
        TITLE,
        APPLY,
        CLOSE,
        APPEARANCE_TAB,
        LANGUAGE_TAB,
        ADVANCE_TAB,
    }

    private KeyedJsonString title = new KeyedJsonString(JsonSettings.class, Keys.TITLE, "Settings");
    private KeyedJsonString apply = new KeyedJsonString(JsonSettings.class, Keys.APPLY, "Apply");
    private KeyedJsonString close = new KeyedJsonString(JsonSettings.class, Keys.CLOSE, "Close");
    private JsonAppearanceTab appearanceTab = new JsonAppearanceTab();
    private JsonLanguageTab languageTab = new JsonLanguageTab();
    private JsonAdvanceTab advanceTab = new JsonAdvanceTab();

    // Getters for object's attributes.
    public KeyedJsonString getTitle() {
        return title;
    }

    public KeyedJsonString getApply() {
        return apply;
    }

    public KeyedJsonString getClose() {
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
    public void setTitle(KeyedJsonString title) {
        this.title = title;
    }

    public void setApply(KeyedJsonString apply) {
        this.apply = apply;
    }

    public void setClose(KeyedJsonString close) {
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
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(title);
            add(apply);
            add(close);
            addAll(appearanceTab.toTranslate());
            addAll(languageTab.toTranslate());
            addAll(advanceTab.toTranslate());
        }};
    }

}