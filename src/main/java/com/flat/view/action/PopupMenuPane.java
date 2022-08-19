package com.flat.view.action;

import com.flat.view.main.panes.top.menupane.FlatMenuPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PopupMenuPane extends ResizePane {
    protected FlatMenuPane flatMenuPane;
    protected boolean toggle = false;
    private int childIndex = 0;

    public PopupMenuPane (Pane _activeObject, Orientation _orientation, Side _side, FlatMenuPane _menuPane) {
        super(_activeObject, _orientation, _side);
        this.flatMenuPane = _menuPane;
    }

    @Override
    protected void setResizeAction() {
        this.getParentPane().setOnMousePressed(event -> {
            this.resizeObject(event);
        });
    }

    @Override
    protected void resizeObject(MouseEvent _event) {
        switch(this.side) {
            case LEFT:
            case RIGHT:
                if (this.toggle){
                    this.activeObject.setPrefWidth(flatMenuPane.getHeight());
                }
                else
                    this.activeObject.setPrefWidth(this.parentPane.getWidth() - 1);
                break;
            case TOP:
            case BOTTOM:
                if (this.toggle) {
                    this.activeObject.setPrefHeight(flatMenuPane.getHeight());
                }
                else
                    this.activeObject.setPrefHeight(this.parentPane.getHeight() - 1);
                break;
        }
        if (!this.toggle) {
            this.childIndex = this.activeObject.getChildren().indexOf(this.flatMenuPane);
            this.activeObject.getChildren().remove(this.childIndex);
        }
        else
            this.activeObject.getChildren().add(this.childIndex, this.flatMenuPane);
        this.toggle ^= true;
    }

}