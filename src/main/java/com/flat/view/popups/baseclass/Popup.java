package com.flat.view.popups.baseclass;

import com.flat.controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Popup extends Stage {
    private double popupWidth = 160;
    private double popupHeight = 90;

    public Popup () {
    }

    public Popup (Pane _pane) {
        super.setScene(new Scene(_pane));
        this.initializeFx();
        super.show();
        this.centerOnStage();
    }

    public Popup (double _width, double _height, Pane _pane) {
        this.popupWidth = _width;
        this.popupHeight = _height;
        super.setScene(new Scene(_pane));
        this.initializeFx();
        super.show();
        this.setSize();
        this.centerOnStage();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.initModality(Modality.WINDOW_MODAL);
        super.initOwner(Controller.STAGE.getScene().getWindow());
        super.initStyle(StageStyle.UNDECORATED);
    }

    private void setSize () {
        super.setWidth(this.popupWidth);
        super.setHeight(this.popupHeight);
    }

    private void centerOnStage () {
        super.setX(Controller.STAGE.getX() + ((Controller.STAGE.getWidth() - super.getWidth()) / 2));
        super.setY(Controller.STAGE.getY() + ((Controller.STAGE.getHeight() - super.getHeight()) / 2));
    }

}