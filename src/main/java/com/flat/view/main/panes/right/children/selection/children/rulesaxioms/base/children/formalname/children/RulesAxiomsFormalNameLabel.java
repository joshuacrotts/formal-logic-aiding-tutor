package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.formalname.children;

import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsFormalNameLabel extends Text {

    public RulesAxiomsFormalNameLabel () {
        super.setText("Formal Name");
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}