package com.flat.tools.json;

import com.flat.controller.Controller;
import com.flat.models.fx.FxMenuBarData;
import com.flat.models.json.language.Language;
import com.flat.models.json.menubar.JsonMenuBar;
import com.flat.models.json.symbol.Predicate;
import com.flat.models.json.symbol.Propositional;
import com.flat.tools.json.enums.JsonLocal;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonData implements Observer {
    private JsonMenuBar jsonMenu;
    private Predicate predicates;
    private Propositional propositional;
    // Language isn't very useful in this format, convert to Json data object.
    private Language[] language = JsonTools.jsonToObjectList(new Language("", "", ""), JsonLocal.File.LANGUAGE, Language[].class);

    public JsonData () {
        Controller.getLanguage().addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (!this.directoryExists()) {
            this.getData(new Language("English", "English", "en"));
            this.translateData();
            this.writeData();
        }
        else {
            this.getData(Controller.getLanguage());
        }
        this.updateFx();
    }

    public boolean directoryExists () {
        return new File(System.getProperty("user.dir") + JsonLocal.Paths.JSONROOT.getFilePath() + "/" + Controller.getLanguage().getCode()).isDirectory();
    }

    public void getData (Language _language) {
        this.jsonMenu = JsonTools.jsonToObject(_language, JsonLocal.File.MENUBAR, JsonMenuBar.class);
    }

    public void updateFx () {
        FxMenuBarData.injectData(this.jsonMenu);
    }

    public void translateData() {
        this.jsonMenu.translate();
    }

    public void writeData () {
        JsonTools.objectToJson(Controller.getLanguage(), JsonLocal.File.MENUBAR, this.jsonMenu, JsonMenuBar.class);
    }

    // Getters for object's attributes.
    public JsonMenuBar getJsonMenu() {
        return jsonMenu;
    }

    public Predicate getPredicates() {
        return predicates;
    }

    public Propositional getPropositional() {
        return propositional;
    }

    public Language[] getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setJsonMenu(JsonMenuBar jsonMenu) {
        this.jsonMenu = jsonMenu;
    }

    public void setPredicates(Predicate predicates) {
        this.predicates = predicates;
    }

    public void setPropositional(Propositional propositional) {
        this.propositional = propositional;
    }

    public void setLanguage(Language[] language) {
        this.language = language;
    }

}