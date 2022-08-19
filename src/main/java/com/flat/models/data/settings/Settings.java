package com.flat.models.data.settings;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.settings.tabs.advanced.AdvancedTabData;
import com.flat.models.data.settings.tabs.appearance.AppearanceTabData;
import com.flat.models.data.settings.tabs.language.LanguageTabData;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class Settings extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        TITLE,
        APPLY,
        CLOSE,
        APPEARANCE_TAB,
        LANGUAGE_TAB,
        ADVANCE_TAB,
    }

    private KeyedText title = new KeyedText(Settings.class, Keys.TITLE, "Settings");
    private KeyedText apply = new KeyedText(Settings.class, Keys.APPLY, "Apply");
    private KeyedText close = new KeyedText(Settings.class, Keys.CLOSE, "Close");
    private AppearanceTabData appearanceTab = new AppearanceTabData();
    private LanguageTabData languageTab = new LanguageTabData();
    private AdvancedTabData advancedTab = new AdvancedTabData();

    public Settings () {
    }

    // Getters for object's attributes.
    public KeyedText getTitle() {
        return title;
    }

    public KeyedText getApply() {
        return apply;
    }

    public KeyedText getClose() {
        return close;
    }

    public AppearanceTabData getAppearanceTab() {
        return appearanceTab;
    }

    public LanguageTabData getLanguageTab() {
        return languageTab;
    }

    public AdvancedTabData getAdvancedTab() {
        return advancedTab;
    }

    // Setters for object's attributes.
    public void setTitle(KeyedText title) {
        this.title = title;
    }

    public void setApply(KeyedText apply) {
        this.apply = apply;
    }

    public void setClose(KeyedText close) {
        this.close = close;
    }

    public void setAppearanceTab(AppearanceTabData appearanceTab) {
        this.appearanceTab = appearanceTab;
    }

    public void setLanguageTab(LanguageTabData languageTab) {
        this.languageTab = languageTab;
    }

    public void setAdvancedTab(AdvancedTabData advancedTab) {
        this.advancedTab = advancedTab;
    }

    @Override
    public String toString() {
        return "Settings{" + "title=" + title + ", apply=" + apply + ", close=" + close + ", appearance=" + appearanceTab + ", languageTab=" + languageTab + ", advancedTab=" + advancedTab + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.title);
            os.writeObject(this.apply);
            os.writeObject(this.close);
            os.writeObject(this.appearanceTab);
            os.writeObject(this.languageTab);
            os.writeObject(this.advancedTab);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.title = (KeyedText) is.readObject();
            this.apply = (KeyedText) is.readObject();
            this.close = (KeyedText) is.readObject();
            this.appearanceTab = (AppearanceTabData) is.readObject();
            this.languageTab = (LanguageTabData) is.readObject();
            this.advancedTab = (AdvancedTabData) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(title);
            add(apply);
            add(close);
            addAll(appearanceTab.toTranslate());
            addAll(languageTab.toTranslate());
            addAll(advancedTab.toTranslate());
        }};
    }

}