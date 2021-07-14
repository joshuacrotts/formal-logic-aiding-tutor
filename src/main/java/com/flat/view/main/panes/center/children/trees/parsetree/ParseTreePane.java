package com.flat.view.main.panes.center.children.trees.parsetree;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.trees.parsetree.listener.ParseTreePaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ParseTreePane extends Pane {

    public ParseTreePane() {
        Controller.getEVENT_BUS().addListener(new ParseTreePaneListener(this));
    }

}