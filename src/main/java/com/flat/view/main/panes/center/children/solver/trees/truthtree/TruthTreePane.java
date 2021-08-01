package com.flat.view.main.panes.center.children.solver.trees.truthtree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.solver.trees.truthtree.listener.TruthTreePaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTreePane extends Pane {

    public TruthTreePane () {
        Controller.EVENT_BUS.addListener(new TruthTreePaneListener(this));
    }

}