package com.flat.view.main.panes.right.children.top.practicetoggle.pane;

import com.flat.controller.Controller;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.children.PracticeModeToggleSwitch;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.geometry.VPos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeTogglePane extends HBox {
    // Attributes.
    private SimpleBooleanProperty toggle = new SimpleBooleanProperty(false);
    // Children.
    private PracticeModeToggleSwitch toggleSwitch = new PracticeModeToggleSwitch();

    public PracticeModeTogglePane () {
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleSwitch);
        super.setWidth(70);
        super.setHeight(20);
        super.setLayoutX(0);
        this.setTextClip();
        super.getStyleClass().setAll("practiceModeTogglePane");
        this.onToggleSetCss();
        this.onToggleSetClip();
        this.setToggleUpdate();
    }

    private void onToggleSetCss () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            super.pseudoClassStateChanged(PseudoClass.getPseudoClass("on"), this.toggle.get());
        });
    }

    private void onToggleSetClip () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            this.setTextClip();
        });
    }

    private void setTextClip () {
        Rectangle rectangle = new Rectangle(super.getBoundsInParent().getWidth(), super.getBoundsInParent().getHeight());
            Text text;
            if (this.toggle.getValue()) {
                text = new Text("On");
                text.setLayoutX(5);
            }
            else {
                text = new Text("Off");
                text.setLayoutX(rectangle.getWidth() - text.getLayoutBounds().getWidth() - 5);
            }
            text.setTextAlignment(TextAlignment.CENTER);
            text.setTextOrigin(VPos.CENTER);
            text.setLayoutY(rectangle.getHeight() / 2);
            Shape shape = Shape.subtract(rectangle, text);
            super.setClip(shape);
    }

    public void setToggleUpdate () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            Controller.DATA_BUS.throwUpdate(new PracticeModeToggle(this.toggle.getValue()));
        });
    }

    public void toggle () {
        this.setToggle(this.toggle.getValue() ^ true);
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