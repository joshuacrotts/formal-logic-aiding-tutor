package com.flat.view.main.panes.center.children.naturaldeduction.listener;

import com.flat.algorithms.models.NDWffTree;
import com.flat.models.algorithms.bus.events.UpdateNaturalDeduction;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.naturaldeduction.NaturalDeductionPane;
import com.flat.view.main.panes.center.children.naturaldeduction.base.naturaldeductionlayout.NaturalDeduction;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPaneListener implements EventListener {
    private NaturalDeductionPane naturalDeductionPane;

    public NaturalDeductionPaneListener (NaturalDeductionPane _naturalDeductionPane) {
        this.naturalDeductionPane = _naturalDeductionPane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.naturalDeductionPane.getChildren().clear();
                break;
            case UPDATE_NATURAL_DEDUCTION:
                this.updateNaturalDeduction(((UpdateNaturalDeduction)_event).getNdWffTree());
                break;
        }
    }

    private void updateNaturalDeduction (ArrayList <NDWffTree> _ndWffTree) {
        this.naturalDeductionPane.getChildren().clear();
        GridPane naturalDeduction = this.createNaturalDeduction(new NaturalDeduction(_ndWffTree));
        this.naturalDeductionPane.getChildren().add(naturalDeduction);
    }

    private GridPane createNaturalDeduction (NaturalDeduction _naturalDeduction) {
        GridPane naturalDeduction = new GridPane();
        naturalDeduction.setHgap(5);
        _naturalDeduction.getLines().forEach(line -> {
            naturalDeduction.add(new Text(String.valueOf(line.getLine() + 1) + "."), 0, line.getLine());
            naturalDeduction.add(new Text(line.getWff()), 1, line.getLine());
            naturalDeduction.add(new Text(line.getStep()), 2, line.getLine());
            naturalDeduction.add(new Text(line.getIndices()), 3, line.getLine());
        });
        return naturalDeduction;
    }

    private void resetScale () {
        this.naturalDeductionPane.setScaleX(1);
        this.naturalDeductionPane.setScaleY(1);
    }

}