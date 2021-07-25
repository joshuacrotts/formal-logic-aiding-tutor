package com.flat.view.settings.scene.pane.children.selection;

import com.flat.view.data.fx.pane.PaneData;
import com.flat.view.settings.scene.pane.children.selection.advance.AdvanceButton;
import com.flat.view.settings.scene.pane.children.selection.apperance.AppearanceButton;
import com.flat.view.settings.scene.pane.children.selection.language.LanguageButton;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SelectionPane extends VBox {
    private AppearanceButton appearance = new AppearanceButton();
    private AdvanceButton advance = new AdvanceButton();
    private LanguageButton language = new LanguageButton();

    public SelectionPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setMinWidth(100);
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
        super.getChildren().addAll(this.appearance, this.advance, this.language);
    }

    // Getters for object's attributes.
    public AppearanceButton getAppearance() {
        return appearance;
    }

    public AdvanceButton getAdvance() {
        return advance;
    }

    public LanguageButton getLanguage() {
        return language;
    }

    // Setters for object's attributes.
    public void setAppearance(AppearanceButton appearance) {
        this.appearance = appearance;
    }

    public void setAdvance(AdvanceButton advance) {
        this.advance = advance;
    }

    public void setLanguage(LanguageButton language) {
        this.language = language;
    }

}