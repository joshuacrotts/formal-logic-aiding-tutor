package com.flat.view.main.panes.right.children.selection;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.PracticeWrapperPane;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.RulesAxiomsWrapperPane;
import com.flat.view.main.panes.right.children.selection.children.selections.RightSelectionHBox;
import com.flat.view.main.panes.right.children.selection.listener.RightSelectionPaneListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RightSelectionPane extends VBox {
    private RightSelectionHBox selectionHBox = new RightSelectionHBox();
    private RulesAxiomsWrapperPane rulesAxiomsPane = new RulesAxiomsWrapperPane();
    private Separator separator = new Separator(Orientation.HORIZONTAL);
    private PracticeWrapperPane practicePane = new PracticeWrapperPane();

    public RightSelectionPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new RightSelectionPaneListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
        super.setSpacing(10);
        this.setSelectionHBoxFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.selectionHBox, this.separator);
    }

    private void setSelectionHBoxFx () {
        VBox.setMargin(this.selectionHBox, new Insets(10, 0, 0, 0));
    }

    // Getters for object's attributes.
    public RulesAxiomsWrapperPane getRulesAxiomsPane() {
        return rulesAxiomsPane;
    }

    public PracticeWrapperPane getPracticePane() {
        return practicePane;
    }

    // Setters for object's attributes.
    public void setRulesAxiomsPane(RulesAxiomsWrapperPane rulesAxiomsPane) {
        this.rulesAxiomsPane = rulesAxiomsPane;
    }

    public void setPracticePane(PracticeWrapperPane practicePane) {
        this.practicePane = practicePane;
    }

}