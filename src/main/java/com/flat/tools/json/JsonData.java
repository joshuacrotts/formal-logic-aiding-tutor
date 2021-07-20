package com.flat.tools.json;

import com.flat.models.json.algorithm.JsonAlgorithms;
import com.flat.view.viewdata.settings.LanguageData;
import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.viewdata.settings.SettingsData;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.logicsymbols.JsonLogicSymbols;
import com.flat.models.json.menubar.JsonMenuBar;
import com.flat.models.json.settings.JsonSettings;
import com.flat.tools.json.enums.JsonLocal;

import java.io.File;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonData {
    private static JsonData instance = null;
    private JsonMenuBar jsonMenuBar;
    private JsonSettings jsonSettings;
    private JsonAlgorithms jsonAlgorithms;
    private JsonLogicSymbols jsonLogicSymbols = new JsonLogicSymbols();
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

    public final void update(JsonLanguage _language) {
        if (_language.equals(JsonLanguage.DEFAULT)) {
            this.constructDefaultData();
        }
        else if (!this.languageDirectoryExists(_language)) {
            this.constructDefaultData();
            this.translateData(_language);
            this.writeData(_language);
        }
        else {
            this.readData(_language);
        }
        this.updateFxData(_language);
    }

    private boolean languageDirectoryExists(JsonLanguage _language) {
        return new File(JsonLocal.Paths.JSONROOT.getFilePath() + "/" + _language.getCode()).isDirectory();
    }

    private void constructDefaultData () {
        this.jsonMenuBar = new JsonMenuBar();
        this.jsonSettings = new JsonSettings();
        this.jsonAlgorithms = new JsonAlgorithms();
    }

    private void readData (JsonLanguage _language) {
        this.jsonMenuBar = JsonTools.jsonToObject(_language, JsonLocal.File.MENUBAR, JsonMenuBar.class);
        this.jsonSettings = JsonTools.jsonToObject(_language, JsonLocal.File.SETTINGS, JsonSettings.class);
        this.jsonAlgorithms = JsonTools.jsonToObject(_language, JsonLocal.File.ALGORITHMS, JsonAlgorithms.class);
    }

    private void translateData (JsonLanguage _language) {
        this.jsonMenuBar.translate(_language);
        this.jsonSettings.translate(_language);
        this.jsonAlgorithms.translate(_language);
    }

    private void writeData (JsonLanguage _language) {
        JsonTools.objectToJson(_language, JsonLocal.File.MENUBAR, this.jsonMenuBar, JsonMenuBar.class);
        JsonTools.objectToJson(_language, JsonLocal.File.SETTINGS, this.jsonSettings, JsonSettings.class);
        JsonTools.objectToJson(_language, JsonLocal.File.ALGORITHMS, this.jsonAlgorithms, JsonAlgorithms.class);
    }

    private void updateFxData (JsonLanguage _language) {
        MenuBarData.injectData(_language, this.jsonMenuBar);
        SettingsData.injectData(_language, this.jsonSettings);
    }

    // Getters for object's attributes.
    public JsonMenuBar getJsonMenuBar() {
        return jsonMenuBar;
    }

    public JsonSettings getJsonSettings() {
        return jsonSettings;
    }

    public JsonAlgorithms getJsonAlgorithms() {
        return jsonAlgorithms;
    }

    public JsonLanguage[] getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setJsonMenuBar(JsonMenuBar jsonMenuBar) {
        this.jsonMenuBar = jsonMenuBar;
    }

    public static void setInstance(JsonData instance) {
        JsonData.instance = instance;
    }

    public void setJsonSettings(JsonSettings jsonSettings) {
        this.jsonSettings = jsonSettings;
    }

    public void setJsonAlgorithms(JsonAlgorithms jsonAlgorithms) {
        this.jsonAlgorithms = jsonAlgorithms;
    }

    public void setLanguage(JsonLanguage[] language) {
        this.language = language;
    }

}