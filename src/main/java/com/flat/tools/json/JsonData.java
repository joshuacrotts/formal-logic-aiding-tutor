package com.flat.tools.json;

import com.flat.view.viewdata.LanguageData;
import com.flat.view.viewdata.MenuBarData;
import com.flat.view.viewdata.SettingsData;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.menubar.JsonMenuBar;
import com.flat.models.json.settings.JsonSettings;
import com.flat.models.json.symbol.Predicate;
import com.flat.models.json.symbol.Propositional;
import com.flat.tools.json.enums.JsonLocal;

import java.io.File;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonData {
    private static JsonData instance = null;
    private JsonMenuBar jsonMenuBar;
    private JsonSettings jsonSettings;
    private Predicate predicates;
    private Propositional propositional;
    private JsonLanguage[] language = JsonTools.jsonToObjectList(JsonLanguage.NONE, JsonLocal.File.LANGUAGE, JsonLanguage[].class);

    private JsonData() {
        LanguageData.injectData(language);
        this.update(JsonLanguage.DEFAULT);
    }

    public static JsonData getInstance() {
        if (instance == null) {
            instance = new JsonData();
        }
        return instance;
    }

    public void update(JsonLanguage _language) {
        if (!this.languageDirectoryExists(_language)) {
            this.readData(JsonLanguage.DEFAULT);
            this.translateData(_language);
            this.writeData(_language);
        } else {
            this.readData(_language);
        }
        this.updateFxData(_language);
    }

    private boolean languageDirectoryExists(JsonLanguage _language) {
        return new File(JsonLocal.Paths.JSONROOT.getFilePath() + "/" + _language.getCode()).isDirectory();
    }

    private void readData(JsonLanguage _language) {
        this.jsonMenuBar = JsonTools.jsonToObject(_language, JsonLocal.File.MENUBAR, JsonMenuBar.class);
        this.jsonSettings = JsonTools.jsonToObject(_language, JsonLocal.File.SETTINGS, JsonSettings.class);
    }

    private void translateData(JsonLanguage _language) {
        this.jsonMenuBar.translate(_language);
        this.jsonSettings.translate(_language);
    }

    private void writeData(JsonLanguage _language) {
        JsonTools.objectToJson(_language, JsonLocal.File.MENUBAR, this.jsonMenuBar, JsonMenuBar.class);
        JsonTools.objectToJson(_language, JsonLocal.File.SETTINGS, this.jsonSettings, JsonSettings.class);
    }

    private void updateFxData(JsonLanguage _language) {
        MenuBarData.injectData(_language, this.jsonMenuBar);
        SettingsData.injectData(_language, this.jsonSettings);
    }

    // Getters for object's attributes.
    public JsonMenuBar getJsonMenuBar() {
        return jsonMenuBar;
    }

    // Setters for object's attributes.
    public void setJsonMenuBar(JsonMenuBar jsonMenuBar) {
        this.jsonMenuBar = jsonMenuBar;
    }

    public Predicate getPredicates() {
        return predicates;
    }

    public void setPredicates(Predicate predicates) {
        this.predicates = predicates;
    }

    public Propositional getPropositional() {
        return propositional;
    }

    public void setPropositional(Propositional propositional) {
        this.propositional = propositional;
    }

    public JsonLanguage[] getLanguage() {
        return language;
    }

    public void setLanguage(JsonLanguage[] language) {
        this.language = language;
    }

}