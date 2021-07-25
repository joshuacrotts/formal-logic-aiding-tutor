package com.flat.view.main.panes.right.children.rulesaxioms.base.children.example.children;

import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsExampleLabel extends Text {

    public RulesAxiomsExampleLabel () {
        super.setText("Examples");
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
    }

}