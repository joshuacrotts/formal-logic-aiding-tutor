package com.flat.view.main.panes.center.children.solver.trees.wrappers;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeGroupWrapper extends Group {

    public TreeGroupWrapper () {
    }

    public final void setChild (Pane _pane) {
        super.getChildren().clear();
        super.getChildren().add(_pane);
    }

}