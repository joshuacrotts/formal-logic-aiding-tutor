package com.flat.view.main.panes.right.children.top.practicetoggle.pane.children;

import com.flat.view.main.panes.right.children.top.practicetoggle.pane.PracticeModeTogglePane;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeModeToggleSwitch extends Button {
    private SimpleBooleanProperty dragProperty = new SimpleBooleanProperty(false);

    public PracticeModeToggleSwitch () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setMinWidth(20);
        this.onThisDrag();
        this.onThisWidthProperty();
        super.getStyleClass().setAll("practiceModeToggleSwitch");
    }

    private void onThisWidthProperty () {
        super.heightProperty().addListener(event -> {
            super.setWidth(super.getHeight());
        });
    }

    private void onThisDrag () {
        super.setOnMouseDragged(event -> {
            this.dragProperty.set(true);
            Point2D sceneToLocal = super.sceneToLocal(event.getSceneX(), event.getSceneY());
            double deltaX = super.getLayoutX() - sceneToLocal.getX();
            if (super.getBoundsInParent().getMaxX() - deltaX < super.getParent().getBoundsInLocal().getMaxX())
                if (super.getBoundsInParent().getMinX() - deltaX > super.getParent().getBoundsInLocal().getMinX())
                    super.setTranslateX(super.getTranslateX() - deltaX);
            else
                    if (super.getBoundsInParent().getMaxX() - deltaX > super.getParent().getBoundsInLocal().getMaxX())
                        super.setTranslateX(super.getParent().getBoundsInLocal().getWidth() - super.getWidth());
                    else if (super.getBoundsInParent().getMinX() - deltaX < super.getParent().getBoundsInLocal().getMinX())
                        super.setTranslateX(0);
            double midpoint = super.getParent().getBoundsInLocal().getMaxX() / 2;
            if (super.getTranslateX() + (super.getWidth() / 2) < midpoint) {

                ((PracticeModeTogglePane)super.getParent()).setToggle(false);
            }
            else {
                ((PracticeModeTogglePane)super.getParent()).setToggle(true);
            }
        });
        super.setOnMouseReleased(event -> {
            if (this.dragProperty.getValue() == true) {
                double midpoint = super.getParent().getBoundsInLocal().getMaxX() / 2;
                if (super.getTranslateX() + (super.getWidth() / 2) < midpoint) {
                    super.setTranslateX(0);
                }
                else {
                    super.setTranslateX(super.getParent().getBoundsInLocal().getWidth() - super.getBoundsInParent().getWidth() - 2);
                }
                this.dragProperty.setValue(false);
            }
            else {
                if (((PracticeModeTogglePane)super.getParent()).getToggle().getValue()) {
                    ((PracticeModeTogglePane)super.getParent()).getToggle().setValue(false);
                    super.setTranslateX(0);
                }
                else {
                    ((PracticeModeTogglePane)super.getParent()).getToggle().setValue(true);
                    super.setTranslateX(super.getParent().getBoundsInLocal().getWidth() - super.getBoundsInParent().getWidth() - 2);
                }
            }
        });
    }

}