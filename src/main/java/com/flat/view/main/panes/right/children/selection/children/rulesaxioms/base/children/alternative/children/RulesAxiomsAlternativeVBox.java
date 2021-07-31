package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.children;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.view.main.panes.right.MainRight;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsAlternativeVBox extends VBox {

    public RulesAxiomsAlternativeVBox (Class _class) {
        this.addChildren(_class);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setSpacing(5);
        super.setAlignment(Pos.CENTER);
    }

    public void addChildren (Class _class) {
        Controller.MAPPED_TEXT_ARRAY.getValue(_class, LogicSymbol.Keys.ALTERNATE).forEach(child -> {
            Text newText = new Text();
            newText.textProperty().bind(child.textProperty());
            newText.fontProperty().bind(child.fontProperty());
            newText.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
            newText.setTextAlignment(TextAlignment.CENTER);
            super.getChildren().add(newText);
        });
    }

}