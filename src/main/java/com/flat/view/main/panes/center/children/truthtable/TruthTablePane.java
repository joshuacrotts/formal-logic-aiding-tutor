package com.flat.view.main.panes.center.children.truthtable;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.truthtable.listener.TruthTablePaneListener;
import javafx.scene.layout.HBox;

/**
 *
 * @author christopherbrantley
 */
public class TruthTablePane extends HBox {

    public TruthTablePane () {
        Controller.EVENT_BUS.addListener(new TruthTablePaneListener(this));
    }

}