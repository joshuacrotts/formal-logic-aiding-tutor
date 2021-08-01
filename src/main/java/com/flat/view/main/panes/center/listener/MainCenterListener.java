package com.flat.view.main.panes.center.listener;

import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.MainCenter;
import com.flat.view.main.panes.center.children.practice.PracticePane;
import com.flat.view.main.panes.center.children.solver.naturaldeduction.NaturalDeductionPane;
import com.flat.view.main.panes.center.children.solver.trees.parsetree.ParseTreePane;
import com.flat.view.main.panes.center.children.solver.trees.truthtree.TruthTreePane;
import com.flat.view.main.panes.center.children.solver.trees.wrappers.HBoxWrapper;
import com.flat.view.main.panes.center.children.solver.trees.wrappers.TreeGroupWrapper;
import com.flat.view.main.panes.center.children.solver.trees.wrappers.VBoxWrapper;
import com.flat.view.main.panes.center.children.solver.truthtable.TruthTablePane;

/**
 *
 * @author christopherbrantley
 */
public class MainCenterListener implements EventListener {
    private MainCenter mainCenter;
    private HBoxWrapper hWrapper = new HBoxWrapper();
    private VBoxWrapper vWrapper = new VBoxWrapper();
    private TreeGroupWrapper group = new TreeGroupWrapper();
    // Content.
    private TruthTreePane truthTreePane = new TruthTreePane();
    private ParseTreePane parseTreePane = new ParseTreePane();
    private TruthTablePane truthTablePane = new TruthTablePane();
    private NaturalDeductionPane naturalDeductionPane = new NaturalDeductionPane();
    private PracticePane practicePane = new PracticePane();

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
                this.group.setChild(this.parseTreePane);
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPort();
                break;
            case TRUTH_TREE_BUTTON_PRESSED:
                this.group.setChild(this.truthTreePane);
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPort();
                break;
            case TRUTH_TABLE_BUTTON_PRESSED:
                this.group.setChild(this.truthTablePane);
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPortHorizontally();
                break;
            case NATURAL_DEDUCTION_BUTTON_PRESSED:
                this.group.setChild(this.naturalDeductionPane);
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPortHorizontally();
            case UPDATE_PRACTICE_PANE:
            case PRACTICE_BUTTON_PRESSED:
                this.group.setChild(this.practicePane);
                this.mainCenter.getLogicVisualPane().updateContent(this.hWrapper);
                this.mainCenter.getLogicVisualPane().centerViewPort();
                break;
            case TREE_NODE_LAYOUT_SET:
                this.mainCenter.getLogicVisualPane().centerViewPort();
                break;
        }
    }

}