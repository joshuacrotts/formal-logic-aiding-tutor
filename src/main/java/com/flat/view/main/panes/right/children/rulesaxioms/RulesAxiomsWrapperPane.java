package com.flat.view.main.panes.right.children.rulesaxioms;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.rulesaxioms.listener.RulesAxiomsWrapperPaneListener;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxiomsWrapperPane extends ScrollPane {

    public RulesAxiomsWrapperPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new RulesAxiomsWrapperPaneListener(this));
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
            if (newVal.doubleValue() < 50)
                super.setVisible(false);
            else
                super.setVisible(true);
        });
    }

}