package com.flat.view.main.panes.center.children.practice;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.practice.listener.PracticePaneListener;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePane extends Pane {
    private PracticePaneListener listener;

    public PracticePane () {
        this.listener = new PracticePaneListener(this);
        Controller.EVENT_BUS.addListener(this.listener);
        Controller.DATA_BUS.addListener(this.listener);
    }

}