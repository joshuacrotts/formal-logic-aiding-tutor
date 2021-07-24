package com.flat.view.popups.base.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class IconButton extends Button {

    public IconButton () {
        super.getStyleClass().add("popupIcon");
        super.setDisabled(true);
    }

}