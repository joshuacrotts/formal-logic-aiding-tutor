package com.flat.view.main.panes.right.children.selection.children.rulesaxioms.base.children.explanation.children;

import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExplanationLabel extends Text {

    public RulesAxiomsExplanationLabel () {
        super.setText("Explanation");
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}