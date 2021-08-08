package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.alternative.children;

import com.flat.controller.Controller;
import com.flat.models.data.rulesaxioms.RulesAxioms;
import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsAlternativeLabel extends Text {

    public RulesAxiomsAlternativeLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.ALTERNATIVE_SYMBOLS).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.ALTERNATIVE_SYMBOLS).fontProperty());
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}