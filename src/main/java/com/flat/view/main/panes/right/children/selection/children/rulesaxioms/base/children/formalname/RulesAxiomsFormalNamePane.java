package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname;

import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname.children.RulesAxiomsFormalNameLabel;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname.children.RulesAxiomsFormalNameText;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsFormalNamePane extends VBox {
    private RulesAxiomsFormalNameLabel label = new RulesAxiomsFormalNameLabel();
    private RulesAxiomsFormalNameText text;

    public RulesAxiomsFormalNamePane (Class _class) {
        this.text = new RulesAxiomsFormalNameText(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.label, this.text);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
    }

}