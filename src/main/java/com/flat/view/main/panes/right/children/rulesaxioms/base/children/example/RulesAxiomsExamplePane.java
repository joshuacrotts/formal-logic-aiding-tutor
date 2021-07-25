package com.flat.view.main.panes.right.children.rulesaxioms.base.children.example;

import com.flat.view.main.panes.right.children.rulesaxioms.base.children.example.children.RulesAxiomsExampleLabel;
import com.flat.view.main.panes.right.children.rulesaxioms.base.children.example.children.RulesAxiomsExampleVBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExamplePane extends VBox {
    private RulesAxiomsExampleLabel label = new RulesAxiomsExampleLabel();
    private RulesAxiomsExampleVBox examples;

    public RulesAxiomsExamplePane (Class _class) {
        this.examples = new RulesAxiomsExampleVBox(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.label, this.examples);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(5);
    }

}