package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative;

import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.children.RulesAxiomsAlternativeLabel;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.children.RulesAxiomsAlternativeVBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsAlternativePane extends VBox {
    private RulesAxiomsAlternativeLabel label = new RulesAxiomsAlternativeLabel();
    private RulesAxiomsAlternativeVBox alternatives;

    public RulesAxiomsAlternativePane (Class _class) {
        this.alternatives = new com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.children.RulesAxiomsAlternativeVBox(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.getChildren().addAll(this.label, this.alternatives);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(5);
    }

}