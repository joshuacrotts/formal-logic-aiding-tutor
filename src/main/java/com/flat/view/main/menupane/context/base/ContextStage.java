package com.flat.view.main.menupane.context.base;

import com.flat.controller.Controller;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ContextStage extends Stage {

    public ContextStage () {
        super(StageStyle.UNDECORATED);
        super.initModality(Modality.NONE);
        super.initOwner(Controller.getStage().getScene().getWindow());
    }

}