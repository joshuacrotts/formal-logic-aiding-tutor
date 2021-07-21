package com.flat.tools.json;

import com.flat.models.json.algorithm.JsonAlgorithms;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.view.data.json.settings.LanguageData;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.logicsymbols.JsonLogicSymbols;
import com.flat.models.json.menubar.JsonMenuBar;
import com.flat.models.json.settings.JsonSettings;
import com.flat.tools.font.FontTool;
import com.flat.tools.json.enums.JsonLocal;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.text.Font;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonData {
    private static JsonData instance = null;
    private JsonMenuBar jsonMenuBar;
    private JsonSettings jsonSettings;
    private JsonAlgorithms jsonAlgorithms;
    private JsonLogicSymbols jsonLogicSymbols;
    private JsonLanguage[] language = JsonTools.jsonToObjectList(JsonLanguage.NONE, JsonLocal.File.LANGUAGE, JsonLanguage[].class);
    private final ArrayList <KeyedJsonString> updates = new ArrayList();
    private Font currentFont;
    // Need to have updates for all Keyed objects.

    private JsonData (JsonLanguage _language) {
        LanguageData.injectData(language);
        this.update(_language);
    }

    public static JsonData getInstance (JsonLanguage _language) {
        if (instance == null) {
            instance = new JsonData(_language);
        }
        return instance;
    }

    public final void update(JsonLanguage _language) {
        this.currentFont = FontTool.getFont(_language.getFont());
        if (_language.getCode().equals("en")) {
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
        this.updateKeyedData();
    }

    private boolean languageDirectoryExists(JsonLanguage _language) {
        return new File(JsonLocal.Paths.JSONROOT.getFilePath() + "/" + _language.getCode()).isDirectory();
    }

    private void constructDefaultData () {
        this.jsonMenuBar = new JsonMenuBar();
        this.jsonSettings = new JsonSettings();
        this.jsonAlgorithms = new JsonAlgorithms();
        this.jsonLogicSymbols = new JsonLogicSymbols();
    }

    private void readData (JsonLanguage _language) {
        this.jsonMenuBar = JsonTools.jsonToObject(_language, JsonLocal.File.MENUBAR, JsonMenuBar.class);
        this.jsonSettings = JsonTools.jsonToObject(_language, JsonLocal.File.SETTINGS, JsonSettings.class);
        this.jsonAlgorithms = JsonTools.jsonToObject(_language, JsonLocal.File.ALGORITHMS, JsonAlgorithms.class);
        this.jsonLogicSymbols = JsonTools.jsonToObject(_language, JsonLocal.File.LOGIC_SYMBOLS, JsonLogicSymbols.class);
    }

    private void translateData (JsonLanguage _language) {
        this.jsonMenuBar.translate(_language);
        this.jsonSettings.translate(_language);
        this.jsonAlgorithms.translate(_language);
        this.jsonLogicSymbols.translate(_language);
    }

    private void writeData (JsonLanguage _language) {
        JsonTools.objectToJson(_language, JsonLocal.File.MENUBAR, this.jsonMenuBar, JsonMenuBar.class);
        JsonTools.objectToJson(_language, JsonLocal.File.SETTINGS, this.jsonSettings, JsonSettings.class);
        JsonTools.objectToJson(_language, JsonLocal.File.ALGORITHMS, this.jsonAlgorithms, JsonAlgorithms.class);
        JsonTools.objectToJson(_language, JsonLocal.File.LOGIC_SYMBOLS, this.jsonLogicSymbols, JsonLogicSymbols.class);
    }

    private void updateKeyedData () {
        this.updates.forEach(update -> {
            update.updateMapText();
            update.updateMapFont(currentFont);
        });
        this.updates.clear();
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

    public JsonLogicSymbols getJsonLogicSymbols() {
        return jsonLogicSymbols;
    }

    public ArrayList<KeyedJsonString> getUpdates() {
        return updates;
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