package com.flat.view.main.panes.right.children.rulesaxioms.base.children.formalname.children;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsFormalNameText extends Text {

    public RulesAxiomsFormalNameText (Class _class) {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(_class, LogicSymbol.Keys.TOOL_TIP).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(_class, LogicSymbol.Keys.TOOL_TIP).fontProperty());
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
    }

}