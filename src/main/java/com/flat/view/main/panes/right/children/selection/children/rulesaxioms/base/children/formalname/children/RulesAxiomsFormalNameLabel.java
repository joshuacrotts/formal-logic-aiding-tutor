package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname.children;

import com.flat.controller.Controller;
import com.flat.models.data.rulesaxioms.RulesAxioms;
import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsFormalNameLabel extends Text {

    public RulesAxiomsFormalNameLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.FORMAL_NAME).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.FORMAL_NAME).fontProperty());
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}