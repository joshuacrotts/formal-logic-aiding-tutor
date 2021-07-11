package com.flat.view.main.panes.top.menupane.context.base;

import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ContextWindow extends VBox {

    public ContextWindow (ContextButton... _contextItems) {
        super.getChildren().addAll(_contextItems);
    }

}