package com.flat.view.main.panes.right.children.selection.children.rulesaxioms;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.selection.children.rulesaxioms.listener.RulesAxiomsWrapperPaneListener;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsWrapperPane extends ScrollPane {
    private double minDisplayWidth = 70;

    public RulesAxiomsWrapperPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new RulesAxiomsWrapperPaneListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx (){
        super.setFitToWidth(true);
        super.setHbarPolicy(ScrollBarPolicy.NEVER);
        super.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
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