package com.flat.view.main.panes.center.children.trees.truthtree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.trees.truthtree.listener.TruthTreePaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreePane extends Pane {

    public TruthTreePane () {
        Controller.getEVENT_BUS().addListener(new TruthTreePaneListener(this));
    }

}