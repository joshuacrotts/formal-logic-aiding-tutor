package com.flat.view.main.panes.center.listener;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.MainCenter;
import com.flat.view.main.panes.center.children.trees.wrappers.HBoxCenterWrapper;
import com.flat.view.main.panes.center.children.trees.wrappers.VBoxCenterWrapper;

/**
 *
 * @author christopherbrantley
 */
public class MainCenterListener implements Listener {
    private MainCenter mainCenter;
    private HBoxCenterWrapper hBoxCenterWrapper = new HBoxCenterWrapper();
    private VBoxCenterWrapper vBoxCenterWrapper = new VBoxCenterWrapper();

    public MainCenterListener (MainCenter _mainCenter) {
        this.mainCenter = _mainCenter;
        this.hBoxCenterWrapper.getChildren().add(this.vBoxCenterWrapper);
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.vBoxCenterWrapper.getChildren().clear();
                break;
            case PARSE_TREE_BUTTON_PRESSED:
                this.vBoxCenterWrapper.getChildren().add(this.mainCenter.getParseTreePane());
                this.mainCenter.getLogicVisualPane().setContent(this.hBoxCenterWrapper);
                break;
        }
    }

}