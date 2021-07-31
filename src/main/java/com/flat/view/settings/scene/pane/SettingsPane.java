package com.flat.view.settings.scene.pane;

import com.flat.view.data.fx.pane.PaneData;
import com.flat.view.settings.scene.pane.children.selection.SelectionPane;
import com.flat.view.settings.scene.pane.children.selection.advanced.advancedpane.AdvancedPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.AppearancePane;
import com.flat.view.settings.scene.pane.children.selection.language.languagepane.LanguagePane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsPane extends HBox {
    private SelectionPane selectionPane = new SelectionPane();
    private Pane selectedContent = null;
    private AppearancePane appearancePane = new AppearancePane();
    private AdvancedPane advancedPane = new AdvancedPane();
    private LanguagePane languagePane = new LanguagePane();
    public SettingsPane() {
        this.initializeFx();
        this.addSelectedContent(appearancePane);
    }

    private void initializeFx () {
        this.setThisFx();
        this.setAppearancePaneFx();
        this.setAdvancedPaneFx();
        this.setLanguagePaneFx();
        this.setAppearanceButtonFx();
        this.setAdvancedButtonFx();
        this.setLanguageButtonFx();
    }

    private void setThisFx () {
        super.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
        super.getChildren().addAll(this.selectionPane);
    }

    private void setAppearancePaneFx () {
        HBox.setHgrow(this.appearancePane, Priority.ALWAYS);
    }

    private void setAdvancedPaneFx () {
        HBox.setHgrow(this.advancedPane, Priority.ALWAYS);
    }

    private void setLanguagePaneFx () {
        HBox.setHgrow(this.languagePane, Priority.ALWAYS);
    }

    private void setAppearanceButtonFx () {
        this.setAppearanceButtonAction();
    }

    private void setAppearanceButtonAction () {
        this.selectionPane.getAppearance().setOnAction(event -> {
            this.addSelectedContent(this.appearancePane);
        });
    }

    private void setAdvancedButtonFx () {
        this.setAdvancedButtonAction();
    }

    private void setAdvancedButtonAction () {
        this.selectionPane.getAdvanced().setOnAction(event -> {
            this.addSelectedContent(this.advancedPane);
        });
    }

    private void setLanguageButtonFx () {
        this.setLanguageButtonAction();
    }

    private void setLanguageButtonAction () {
        this.selectionPane.getLanguage().setOnAction(event -> {
            this.addSelectedContent(this.languagePane);
        });
    }

    private void addSelectedContent (Pane _pane) {
        if (this.selectedContent != null)
            super.getChildren().remove(this.selectedContent);
        this.selectedContent = _pane;
        super.getChildren().add(_pane);
    }

}