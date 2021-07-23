package com.flat.view.main.panes.top.menupane.context.base;

import com.flat.controller.Controller;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ContextStage extends Stage {

    public ContextStage () {
        super(StageStyle.UNDECORATED);
        super.initModality(Modality.NONE);
        super.initOwner(Controller.STAGE.getScene().getWindow());
    }

}