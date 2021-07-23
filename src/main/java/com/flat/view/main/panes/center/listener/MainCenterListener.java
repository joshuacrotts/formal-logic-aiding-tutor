package com.flat.view.main.panes.center.listener;

import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.MainCenter;
import com.flat.view.main.panes.center.children.trees.wrappers.HBoxWrapper;
import com.flat.view.main.panes.center.children.trees.wrappers.TreeGroupWrapper;
import com.flat.view.main.panes.center.children.trees.wrappers.VBoxWrapper;

/**
 *
 * @author christopherbrantley
 */
public class MainCenterListener implements EventListener {
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
                break;
            case TRUTH_TABLE_BUTTON_PRESSED:
                this.group.setChild(this.mainCenter.getTruthTablePane());
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPortHorizontally();
                break;
        }
    }

}