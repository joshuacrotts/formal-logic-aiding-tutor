package com.flat.view.main.menupane.context.base;

import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ContextWindow extends VBox {

    public ContextWindow (ContextButton... _contextItems) {
        super.getChildren().addAll(_contextItems);
    }

}