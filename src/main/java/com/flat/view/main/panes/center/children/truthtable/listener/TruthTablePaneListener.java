package com.flat.view.main.panes.center.children.truthtable.listener;

import com.flat.models.algorithms.events.UpdateTruthTable;
import com.flat.models.treenode.WffTree;
import com.flat.tools.eventbus.base.Event;
import com.flat.tools.eventbus.base.Listener;
import com.flat.view.main.panes.center.children.truthtable.TruthTablePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author christopherbrantley
 */
public class TruthTablePaneListener implements Listener {
    private TruthTablePane truthTablePane;

    public TruthTablePaneListener (TruthTablePane _truthTablePane) {
        this.truthTablePane = _truthTablePane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.truthTablePane.getChildren().clear();
                break;
            case UPDATE_TRUTH_TABLE:
                this.updateTruthTable(((UpdateTruthTable)_event).getWffTree().getChild(0));
                break;
        }
    }

    private void updateTruthTable (WffTree _wffTree) {
        System.out.println("here");
        this.truthTablePane.getChildren().clear();
        this.createTruthTable(_wffTree);
    }

    private void createTruthTable (WffTree _wffTree) {
        Text wffSymbol = new Text(_wffTree.getStringRep());
        VBox truthColumn = new VBox(wffSymbol);
        _wffTree.getTruthValues().forEach(truthValue -> {
            truthColumn.getChildren().add(new Text(truthValue.toString()));
        });
        _wffTree.getChildren().forEach(child -> {
            this.createTruthTable(child);
        });
        this.truthTablePane.getChildren().add(truthColumn);
    }

}