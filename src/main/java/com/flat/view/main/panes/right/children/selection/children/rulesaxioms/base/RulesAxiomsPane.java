package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base;

import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.RulesAxiomsAlternativePane;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.example.RulesAxiomsExamplePane;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation.RulesAxiomsExplanationPane;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname.RulesAxiomsFormalNamePane;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.name.RulesAxiomsNamePane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsPane extends VBox {
    private RulesAxiomsNamePane name;
    private RulesAxiomsFormalNamePane formalName;
    private RulesAxiomsAlternativePane alternative;
    private RulesAxiomsExplanationPane explanation;
    private RulesAxiomsExamplePane example;

    public RulesAxiomsPane (Class _class) {
        this.name = new RulesAxiomsNamePane(_class);
        this.formalName = new RulesAxiomsFormalNamePane(_class);
        this.alternative = new RulesAxiomsAlternativePane(_class);
        this.explanation = new RulesAxiomsExplanationPane(_class);
        this.example = new RulesAxiomsExamplePane(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.name, this.formalName, this.alternative,
                this.explanation, this.example);
        super.setSpacing(20);
        super.setPadding(new Insets(10, 30, 10, 10));
        super.setAlignment(Pos.CENTER);
    }

}