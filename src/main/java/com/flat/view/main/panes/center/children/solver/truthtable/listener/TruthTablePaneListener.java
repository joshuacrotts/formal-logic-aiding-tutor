package com.flat.view.main.panes.center.children.solver.truthtable.listener;

import com.flat.models.algorithms.bus.events.solver.UpdateTruthTable;
import com.flat.models.treenode.WffTree;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.solver.truthtable.TruthTablePane;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableElement;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableHeader;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TruthTable;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.HorizontalTruthTableSeparator;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.TruthTableHeaderTextVBox;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.TruthTableTextVBox;
import javafx.scene.layout.GridPane;

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
        _table.getHeaders().forEach(header -> {
                gridPane.getChildren().add(new TruthTableHeaderTextVBox(header));
                if (header.getType() != TableHeader.Type.VERTICAL)
                    header.getElements().forEach(element -> {
                        if (element.getType() == TableElement.Type.REGULAR)
                            gridPane.add(new TruthTableTextVBox(element), header.getColumn(), element.getRow());
                    });
        });
        gridPane.add(new HorizontalTruthTableSeparator(), 0, 1, _table.getHeaders().size(), 1);
        return gridPane;
    }

    private void resetScale () {
        this.truthTablePane.setScaleX(1);
        this.truthTablePane.setScaleY(1);
    }

}