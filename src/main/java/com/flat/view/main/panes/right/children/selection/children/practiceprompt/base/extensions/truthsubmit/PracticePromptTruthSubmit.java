package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.buttons.PracticeSubmitTruthButton;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.buttons.events.PracticeSubmitTruthButtonPressed;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.truthselection.PracticeTruthSelectionPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePromptTruthSubmit extends PracticePrompt {
    private PracticeTruthSelectionPane truthSelection = new PracticeTruthSelectionPane();
    private Region emptyRegion = new Region();
    private PracticeSubmitTruthButton submitTruth = new PracticeSubmitTruthButton();

    public PracticePromptTruthSubmit(String _prompt, String _info) {
        super(_prompt, _info);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setEmptyRegionFx();
        this.setSubmitTruthFx();
    }

    private void setThisFx () {
        super.getChildren().add(this.truthSelection);
        super.getChildren().add(this.emptyRegion);
        super.getChildren().add(this.submitTruth);
    }

    private void setEmptyRegionFx () {
        this.emptyRegion.setMinHeight(25);
        VBox.setVgrow(this.emptyRegion, Priority.ALWAYS);
    }

    private void setSubmitTruthFx () {
        this.setSubmitTruthOnAction();
    }

    private void setSubmitTruthOnAction () {
        this.submitTruth.setOnAction(event -> {
            Controller.EVENT_BUS.throwEvent(new PracticeSubmitTruthButtonPressed(this.truthSelection.getTruthValue()));
        });
    }

}