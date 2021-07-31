package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.children.text;

import com.flat.view.main.panes.right.MainRight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PromptResultLabel extends Text {

    public PromptResultLabel () {
        super("Result");
        super.wrappingWidthProperty().bind(MainRight.WRAPPING_WIDTH);
        super.setTextAlignment(TextAlignment.CENTER);
        super.setUnderline(true);
    }

}