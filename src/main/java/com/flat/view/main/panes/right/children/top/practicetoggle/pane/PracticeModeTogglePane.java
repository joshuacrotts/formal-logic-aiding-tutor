package com.flat.view.main.panes.right.children.top.practicetoggle.pane;

import com.flat.view.main.panes.right.children.top.practicetoggle.pane.children.PracticeModeToggleSwitch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.scene.layout.HBox;

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
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.toggleSwitch);
        super.setLayoutX(0);
        super.getStyleClass().setAll("practiceModeTogglePane");
        this.onToggleSetCss();
    }

    private void onToggleSetCss () {
        this.toggle.addListener((obs, oldVal, newVal) -> {
            super.pseudoClassStateChanged(PseudoClass.getPseudoClass("on"), this.toggle.get());
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