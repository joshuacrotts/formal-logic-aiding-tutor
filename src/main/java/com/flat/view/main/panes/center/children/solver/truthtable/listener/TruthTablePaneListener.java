package com.flat.view.main.panes.center.children.solver.truthtable.listener;

import com.flat.models.algorithms.bus.events.solver.UpdateTruthTable;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.view.main.panes.center.children.solver.truthtable.TruthTablePane;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TruthTable;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import com.flat.tools.buses.eventbus.components.EventListener;

/**
 *
 * @author christopherbrantley
 */
public class TruthTablePaneListener implements EventListener {
    private TruthTablePane truthTablePane;

    public TruthTablePaneListener (TruthTablePane _truthTablePane) {
        this.truthTablePane = _truthTablePane;
    }

    @Override
    public void catchEvent (Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.truthTablePane.getChildren().clear();
                break;
            case UPDATE_TRUTH_TABLE:
                this.resetScale();
                this.updateTruthTable(((UpdateTruthTable)_event).getWffTree().getChild(0));
                break;
        }
    }

    private void updateTruthTable (WffTree _wffTree) {
        this.truthTablePane.getChildren().clear();
        GridPane gridPane = this.createTruthTable(new TruthTable(_wffTree));
        this.truthTablePane.getChildren().add(gridPane);
    }

    private GridPane createTruthTable (TruthTable _table) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        _table.getHeaders().forEach(header -> {
            gridPane.add(new Text(header.getText()), header.getColumn(), 0);
            header.getElements().forEach(element -> {
                gridPane.add(new Text(element.getText()), header.getColumn(), element.getRow());
            });
        });
        gridPane.getChildren().forEach(child -> {
            GridPane.setHgrow(child, Priority.ALWAYS);
            GridPane.setHalignment(child, HPos.CENTER);
        });
        return gridPane;
    }

    private void resetScale () {
        this.truthTablePane.setScaleX(1);
        this.truthTablePane.setScaleY(1);
    }

}