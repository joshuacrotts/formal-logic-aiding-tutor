package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation.children;

import com.flat.controller.Controller;
import com.flat.models.data.rulesaxioms.RulesAxioms;
import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExplanationLabel extends Text {

    public RulesAxiomsExplanationLabel () {
        super.textProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.EXPLANATION).textProperty());
        super.fontProperty().bind(Controller.MAPPED_TEXT.getValue(RulesAxioms.class, RulesAxioms.Keys.EXPLANATION).fontProperty());
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}