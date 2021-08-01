package com.flat.view.main.panes.right.children.top.practicetoggle.pane;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.children.PracticeModeToggleSwitch;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeTogglePane extends Pane {
    // Attributes.
    private SimpleBooleanProperty toggle = new SimpleBooleanProperty(false);
    private Text toggleText = new Text("Practice Mode: OFF");
    // Children.
    private PracticeModeToggleSwitch toggleSwitch = new PracticeModeToggleSwitch();

    public PracticeModeTogglePane () {
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
    }

    private void initializeFx () {
        this.setThisFx();
        this.setToggleTextFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleText, this.toggleSwitch);
        super.setWidth(150);
        super.setMaxWidth(150);
        super.setHeight(20);
        super.setMaxHeight(20);
        super.setLayoutX(0);
        super.getStyleClass().setAll("practiceModeTogglePane");
        this.onToggleSetCss();
        this.onToggleSetToggleText();
        this.setToggleUpdate();
    }

    private void setToggleTextFx () {
        this.toggleText.setTextAlignment(TextAlignment.CENTER);
        this.toggleText.setTextOrigin(VPos.CENTER);
        this.setToggleText();
    }

    private void onToggleSetCss () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            super.pseudoClassStateChanged(PseudoClass.getPseudoClass("on"), this.toggle.get());
        });
    }

    private void onToggleSetToggleText () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            this.setToggleText();
        });
    }

    private void setToggleText () {
            if (this.toggle.getValue()) {
                this.toggleText.setText("Practice Mode: ON");
                this.toggleText.setLayoutX(10);
            }
            else {
                this.toggleText.setText("Practice Mode: OFF");
                this.toggleText.setLayoutX(super.getWidth() - this.toggleText.getLayoutBounds().getWidth() - 10);
            }
            this.toggleText.setLayoutY((super.getHeight()) / 2);
    }

    public void setToggleUpdate () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
        });
    }

    public void toggle () {
        this.setToggle(!this.toggle.getValue());
    }

    // Getters for object's attributes.
    public SimpleBooleanProperty getToggle() {
        return toggle;
    }

    // Setters for object's attributes.
    public void setToggle(boolean _boolean) {
        this.toggle.set(_boolean);
    }

}