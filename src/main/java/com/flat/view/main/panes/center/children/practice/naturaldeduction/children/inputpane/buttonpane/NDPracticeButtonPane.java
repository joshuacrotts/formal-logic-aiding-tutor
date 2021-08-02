package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane;

import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane.buttons.NDPracticeEnterButton;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.buttonpane.buttons.NDPracticeResetButton;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NDPracticeButtonPane extends HBox {
    private NDPracticeEnterButton enter = new NDPracticeEnterButton();
    private NDPracticeResetButton reset = new NDPracticeResetButton();

    public NDPracticeButtonPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.enter, this.reset);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(100);
    }

    // Getters for object's attributes.
    public NDPracticeEnterButton getEnter() {
        return enter;
    }

    public NDPracticeResetButton getReset() {
        return reset;
    }

    // Setters for object's attributes.
    public void setEnter(NDPracticeEnterButton enter) {
        this.enter = enter;
    }

    public void setReset(NDPracticeResetButton reset) {
        this.reset = reset;
    }

}