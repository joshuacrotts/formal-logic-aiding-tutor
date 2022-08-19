package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.children.text.*;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.listener.PracticePromptListener;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class PracticePrompt extends VBox {
    private String prompt;
    private String info;
    private PromptResultText result = new PromptResultText();
    private Region emptyRegion = new Region();

    public PracticePrompt (String _prompt, String _info) {
        this.prompt = _prompt;
        this.info = _info;
        this.initializeFx();
        Controller.DATA_BUS.addListener(new PracticePromptListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setThisEmptyRegionFx();
    }

    private void setThisFx () {
        super.getChildren().add(new PromptLabel());
        PromptText promptText = new PromptText(this.prompt);
        promptText.setTextAlignment(TextAlignment.JUSTIFY);
        super.getChildren().add(promptText);
        super.getChildren().add(new InfoLabel());
        PromptText infoText = new PromptText(this.info);
        infoText.setTextAlignment(TextAlignment.JUSTIFY);
        super.getChildren().add(infoText);
        super.getChildren().add(new PromptResultLabel());
        super.getChildren().add(this.result);
        super.getChildren().add(this.emptyRegion);
        super.setSpacing(5);
        super.setAlignment(Pos.CENTER);
    }

    private void setThisEmptyRegionFx () {
        this.emptyRegion.setMinHeight(25);
        VBox.setVgrow(this.emptyRegion, Priority.ALWAYS);
    }

    // Getters for object's attributes.
    public String getPrompt() {
        return prompt;
    }

    public String getInfo() {
        return info;
    }

    public PromptResultText getResult() {
        return result;
    }

    // Setters for object's attributes.
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setResult(PromptResultText result) {
        this.result = result;
    }

}