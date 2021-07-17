package com.flat.view.main.panes.center.listener;

import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.MainCenter;
import com.flat.view.main.panes.center.children.trees.wrappers.HBoxWrapper;
import com.flat.view.main.panes.center.children.trees.wrappers.TreeGroupWrapper;
import com.flat.view.main.panes.center.children.trees.wrappers.VBoxWrapper;

/**
 *
 * @author christopherbrantley
 */
public class MainCenterListener implements Listener {
    private MainCenter mainCenter;
    private HBoxWrapper hWrapper = new HBoxWrapper();
    private VBoxWrapper vWrapper = new VBoxWrapper();
    private TreeGroupWrapper group = new TreeGroupWrapper();

    public MainCenterListener (MainCenter _mainCenter) {
        this.mainCenter = _mainCenter;
        this.hWrapper.setChild(this.vWrapper);
        this.vWrapper.setChild(this.group);
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.group.getChildren().clear();
                this.mainCenter.getLogicVisualPane().setContent(null);
                break;
            case PARSE_TREE_BUTTON_PRESSED:
                this.group.setChild(this.mainCenter.getParseTreePane());
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPort();
                break;
            case TRUTH_TREE_BUTTON_PRESSED:
                this.group.setChild(this.mainCenter.getTruthTreePane());
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPort();
        }
    }

}