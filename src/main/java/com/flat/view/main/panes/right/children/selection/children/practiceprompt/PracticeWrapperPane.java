package com.flat.view.main.panes.right.children.selection.children.practiceprompt;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.listener.PracticePromptWrapperPaneListener;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeWrapperPane extends ScrollPane {
    private double minDisplayWidth = 70;
    private PracticePromptWrapperPaneListener listener;

    public PracticeWrapperPane () {
        this.initializeFx();
        this.listener = new PracticePromptWrapperPaneListener(this);
        Controller.EVENT_BUS.addListener(this.listener);
        Controller.DATA_BUS.addListener(this.listener);
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx (){
        super.setFitToWidth(true);
        super.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        super.setMinWidth(0);
        this.onWidthProperty();
    }

    private void onWidthProperty () {
        super.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() < this.minDisplayWidth)
                super.setVisible(false);
            else
                super.setVisible(true);
        });
    }

}