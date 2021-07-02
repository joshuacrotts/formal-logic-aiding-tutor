package com.flat.view.viewdata.settings;

import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.settings.JsonSettings;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsData {
    private final static Text title = new Text();
    private final static Text apply = new Text();
    private final static Text close = new Text();
    private final static Text appearanceTab = new Text();
    private final static Text primaryColor = new Text();
    private final static Text secondaryColor = new Text();
    private final static Text borderColor = new Text();
    private final static Text languageTab = new Text();
    private final static Text advanceTab = new Text();
    private final static Text predicateNDV = new Text();
    private final static Text predicateTruthTree = new Text();
    private final static Text propositionalNDV = new Text();
    private final static Text propositionalTruthTree = new Text();
    private final static Text truthTableGenerator = new Text();
    private final static Text message = new Text();
    private final static Text messageText = new Text();
    private final static Text error = new Text();
    private final static Text errorText = new Text();
    private final static Text ok = new Text();
    private final static Text predicateNDVTimeout = new Text("100");
    private final static Text predicateTruthTreeTimeout = new Text("100");
    private final static Text propositionalNDVTimeout = new Text("100");
    private final static Text propositionalTruthTreeTimeout = new Text("100");
    private final static Text truthTableTimeout = new Text("100");

    public static void injectData(JsonLanguage _jsonLanguage, JsonSettings _jsonSettings) {
        title.setText(_jsonSettings.getTitle().getString());
        apply.setText(_jsonSettings.getApply().getString());
        close.setText(_jsonSettings.getClose().getString());
        appearanceTab.setText(_jsonSettings.getAppearanceTab().getAppearance().getString());
        primaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getPrimaryColor().getString());
        secondaryColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getSecondaryColor().getString());
        borderColor.setText(_jsonSettings.getAppearanceTab().getJsonColorPane().getBorderColor().getString());
        languageTab.setText(_jsonSettings.getLanguageTab().getLanguage().getString());
        advanceTab.setText(_jsonSettings.getAdvanceTab().getAdvance().getString());
        predicateNDV.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getPredicateNDV().getString());
        predicateTruthTree.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getPredicateTruthTree().getString());
        propositionalNDV.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getPropositionalNDV().getString());
        propositionalTruthTree.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getPropositionalTruthTree().getString());
        truthTableGenerator.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getTruthTableGenerator().getString());
        message.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getAdvanceAlert().getMessage().getString());
        messageText.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getAdvanceAlert().getMessageText().getString());
        error.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getAdvanceAlert().getError().getString());
        errorText.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getAdvanceAlert().getErrorText().getString());
        ok.setText(_jsonSettings.getAdvanceTab().getAdvancePane().getAdvanceAlert().getOk().getString());
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

    public static Text getAppearanceTab() {
        return appearanceTab;
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

    public static Text getLanguageTab() {
        return languageTab;
    }

    public static Text getPredicateNDVTimeout() {
        return predicateNDVTimeout;
    }

    public static Text getPredicateTruthTreeTimeout() {
        return predicateTruthTreeTimeout;
    }

    public static Text getPropositionalNDVTimeout() {
        return propositionalNDVTimeout;
    }

    public static Text getPropositionalTruthTreeTimeout() {
        return propositionalTruthTreeTimeout;
    }

    public static Text getTruthTableTimeout() {
        return truthTableTimeout;
    }

    public static Text getAdvanceTab() {
        return advanceTab;
    }

    public static Text getPredicateNDV() {
        return predicateNDV;
    }

    public static Text getPredicateTruthTree() {
        return predicateTruthTree;
    }

    public static Text getPropositionalNDV() {
        return propositionalNDV;
    }

    public static Text getPropositionalTruthTree() {
        return propositionalTruthTree;
    }

    public static Text getTruthTableGenerator() {
        return truthTableGenerator;
    }

    public static Text getMessage() {
        return message;
    }

    public static Text getMessageText() {
        return messageText;
    }

    public static Text getError() {
        return error;
    }

    public static Text getErrorText() {
        return errorText;
    }

    public static Text getOk() {
        return ok;
    }

}