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
        Controller.getEVENT_BUS().addListener(new TruthTablePaneListener(this));
    }

}