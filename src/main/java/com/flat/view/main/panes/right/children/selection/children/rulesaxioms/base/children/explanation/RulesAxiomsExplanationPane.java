package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation;

import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation.children.RulesAxiomsExplanationLabel;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation.children.RulesAxiomsExplanationText;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExplanationPane extends VBox {
    private RulesAxiomsExplanationLabel label = new RulesAxiomsExplanationLabel();
    private RulesAxiomsExplanationText text;

    public RulesAxiomsExplanationPane (Class _class) {
        this.text = new RulesAxiomsExplanationText(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.label, this.text);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(5);
    }

}