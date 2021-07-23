package com.flat.tools.data.serial;

import com.flat.models.data.algorithms.Algorithms;
import com.flat.models.data.logicsymbols.LogicSymbols;
import com.flat.models.data.menubar.MenuBar;
import com.flat.models.data.settings.Settings;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.data.base.enums.LocalData;
import java.io.File;

/**
 *
 * @author christopherbrantley
 */
public class SerialData {
    private static SerialData instance = null;
    private Algorithms algorithms;
    private LogicSymbols logicSymbols;
    private MenuBar menuBar;
    private Settings settings;

    private SerialData (JsonLanguage _language) {
        this.update(_language);
    }

    public static SerialData getInstance (JsonLanguage _language) {
        if (instance == null)
            instance = new SerialData(_language);
        return instance;
    }

    // Getters for object's attributes.
    public Algorithms getAlgorithms() {
        return algorithms;
    }

    public LogicSymbols getLogicSymbols() {
        return logicSymbols;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Settings getSettings() {
        return settings;
    }

    // Setters for object's attributes.
    public void setAlgorithms(Algorithms algorithms) {
        this.algorithms = algorithms;
    }

    public void setLogicSymbols(LogicSymbols logicSymbols) {
        this.logicSymbols = logicSymbols;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public final void update (JsonLanguage _language) {
        if (this.languageDirectoryExists(_language) && !"en".equals(_language.getCode()))
            this.readData(_language);
        else {
            this.constructDefaultData();
            if (!_language.getCode().equals("en")) {
                this.translateData(_language);
                this.writeData(_language);
            }
        }
    }

    public final void constructDefaultData () {
        this.algorithms = new Algorithms();
        this.logicSymbols = new LogicSymbols();
        this.menuBar = new MenuBar();
        this.settings = new Settings();
    }

    public final boolean languageDirectoryExists (JsonLanguage _language) {
        return new File(LocalData.Paths.SERIAL_ROOT.getFilePath() + "/" + _language.getCode()).isDirectory();
    }

    private void readData (JsonLanguage _language) {
        this.algorithms = SerialTools.deserializeObject(_language, LocalData.File.ALGORITHMS, Algorithms.class);
        this.logicSymbols = SerialTools.deserializeObject(_language, LocalData.File.LOGIC_SYMBOLS, LogicSymbols.class);
        this.menuBar = SerialTools.deserializeObject(_language, LocalData.File.MENU_BAR, MenuBar.class);
        this.settings = SerialTools.deserializeObject(_language, LocalData.File.SETTINGS, Settings.class);
    }

    private void translateData (JsonLanguage _language) {
        this.algorithms.translate(_language);
        this.logicSymbols.translate(_language);
        this.menuBar.translate(_language);
        this.settings.translate(_language);
    }

    private void writeData (JsonLanguage _language) {
        SerialTools.serializeObject(_language, LocalData.File.ALGORITHMS, this.algorithms, Algorithms.class);
        SerialTools.serializeObject(_language, LocalData.File.LOGIC_SYMBOLS, this.logicSymbols, LogicSymbols.class);
        SerialTools.serializeObject(_language, LocalData.File.MENU_BAR, this.menuBar, MenuBar.class);
        SerialTools.serializeObject(_language, LocalData.File.SETTINGS, this.settings, Settings.class);
    }

}