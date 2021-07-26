package com.flat.view.main.panes.right.children.rulesaxioms.base.children.explanation.children;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExplanationText extends Text {

    public RulesAxiomsExplanationText (Class _class) {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(_class, LogicSymbol.Keys.EXPLANATION).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(_class, LogicSymbol.Keys.EXPLANATION).fontProperty());
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.JUSTIFY);
    }

}