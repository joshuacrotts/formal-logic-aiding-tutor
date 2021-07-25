package com.flat.view.main.panes.right.children.rulesaxioms.base.children.name;

import com.flat.view.main.panes.right.children.rulesaxioms.base.children.name.children.RulesAxiomsNameLabel;
import com.flat.view.main.panes.right.children.rulesaxioms.base.children.name.children.RulesAxiomsNameText;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsNamePane extends VBox {
    private RulesAxiomsNameLabel label = new RulesAxiomsNameLabel();
    private RulesAxiomsNameText text;

    public RulesAxiomsNamePane (Class _class) {
        this.text = new RulesAxiomsNameText(_class);
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