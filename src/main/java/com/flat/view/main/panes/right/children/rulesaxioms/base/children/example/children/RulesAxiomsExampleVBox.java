package com.flat.view.main.panes.right.children.rulesaxioms.base.children.example.children;

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
public class RulesAxiomsExampleVBox extends VBox {

    public RulesAxiomsExampleVBox (Class _class) {
        this.addChildren(_class);
        super.getChildren().addAll();
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setSpacing(5);
        super.setAlignment(Pos.CENTER);
    }

    private void addChildren (Class _class) {
        Controller.MAPPED_TEXT_ARRAY.getValue(_class, LogicSymbol.Keys.EXAMPLES).forEach(child -> {
            Text newText = new Text();
            newText.textProperty().bind(child.textProperty());
            newText.fontProperty().bind(child.fontProperty());
            newText.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
            newText.setTextAlignment(TextAlignment.JUSTIFY);
            super.getChildren().add(newText);
        });
    }

}