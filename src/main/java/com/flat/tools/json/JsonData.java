package com.flat.tools.json;

import com.flat.controller.Controller;
import com.flat.models.fx.FxLanguageData;
import com.flat.models.fx.FxMenuBarData;
import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.menubar.JsonMenuBar;
import com.flat.models.json.symbol.Predicate;
import com.flat.models.json.symbol.Propositional;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import com.flat.tools.json.enums.JsonLocal;
import java.io.File;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonData {
    private static JsonData instance = null;
    private JsonMenuBar jsonMenuBar;
    private Predicate predicates;
    private Propositional propositional;
    private JsonLanguage[] language = JsonTools.jsonToObjectList(new JsonLanguage("", "", "", FontFamily.DEFAULT), JsonLocal.File.LANGUAGE, JsonLanguage[].class);

    private JsonData() {
        FxLanguageData.injectData(language);
    }

    public static JsonData getInstance () {
        if (instance == null) {
            instance = new JsonData();
        }
        return instance;
    }

    public void update(JsonLanguage _language) {
        if (!this.directoryExists()) {
            this.retrieveData(new JsonLanguage("English", "English", "en", FontFamily.DEFAULT));
            this.translateData(_language);
            this.writeData(_language);
        } else {
            this.retrieveData(_language);
        }
        this.updateFxData();
    }

    public boolean directoryExists() {
        return new File(System.getProperty("user.dir") + JsonLocal.Paths.JSONROOT.getFilePath() + "/" + Controller.getJsonLanguage().getCode()).isDirectory();
    }

    public void retrieveData(JsonLanguage _language) {
        this.jsonMenuBar = JsonTools.jsonToObject(_language, JsonLocal.File.MENUBAR, JsonMenuBar.class);
    }

    public void updateFxData() {
        FxMenuBarData.injectData(this.jsonMenuBar);
    }

    public void translateData(JsonLanguage _language) {
        this.jsonMenuBar.translate(_language);
    }

    public void writeData(JsonLanguage _language) {
        JsonTools.objectToJson(_language, JsonLocal.File.MENUBAR, this.jsonMenuBar, JsonMenuBar.class);
    }

    // Getters for object's attributes.
    public JsonMenuBar getJsonMenuBar() {
        return jsonMenuBar;
    }

    public Predicate getPredicates() {
        return predicates;
    }

    public Propositional getPropositional() {
        return propositional;
    }

    public JsonLanguage[] getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setJsonMenuBar(JsonMenuBar jsonMenuBar) {
        this.jsonMenuBar = jsonMenuBar;
    }

    public void setPredicates(Predicate predicates) {
        this.predicates = predicates;
    }

    public void setPropositional(Propositional propositional) {
        this.propositional = propositional;
    }

    public void setLanguage(JsonLanguage[] language) {
        this.language = language;
    }

}