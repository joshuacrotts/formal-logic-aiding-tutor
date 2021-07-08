package com.flat.view.action;

import com.flat.view.action.ResizePane.Side;
import com.flat.view.main.menubar.FLATMenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PopupPane extends ResizePane {
    protected FLATMenuBar flatMenuBar;
    protected boolean toggle = false;

    public PopupPane (Pane _activeObject, Orientation _orientation, Side _side, FLATMenuBar _menuBar) {
        super(_activeObject, _orientation, _side);
        this.flatMenuBar = _menuBar;
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
                    this.activeObject.setPrefWidth(flatMenuBar.getHeight());
                }
                else
                    this.activeObject.setPrefWidth(this.parentPane.getWidth() - 1);
                break;
            case TOP:
            case BOTTOM:
                if (this.toggle) {
                    this.activeObject.setPrefHeight(flatMenuBar.getHeight());
                }
                else
                    this.activeObject.setPrefHeight(this.parentPane.getHeight() - 1);
                break;
        }
        this.flatMenuBar.setVisible(toggle);
        this.toggle = !this.toggle;
    }

}