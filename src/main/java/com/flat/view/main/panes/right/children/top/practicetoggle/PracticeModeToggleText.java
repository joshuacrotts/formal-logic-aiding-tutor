package com.flat.view.main.panes.right.children.top.practicetoggle;

import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeToggleText extends Text {

    public PracticeModeToggleText () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setText("Practice Mode");
        super.setUnderline(true);
    }

}