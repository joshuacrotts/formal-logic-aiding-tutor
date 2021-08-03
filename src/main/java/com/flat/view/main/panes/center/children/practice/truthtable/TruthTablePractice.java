package com.flat.view.main.panes.center.children.practice.truthtable;

import com.flat.controller.Controller;
import com.flat.models.treenode.WffTree;
import com.flat.view.main.panes.center.children.practice.base.Practice;
import com.flat.view.main.panes.center.children.practice.base.wff.bus.updates.PracticePaneUpdate;
import com.flat.view.main.panes.center.children.practice.truthtable.children.TruthTablePracticeGridPane;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TruthTable;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTablePractice extends Pane implements Practice {
    private WffTree wffTree;
    private TruthTable truthTable;
    private TruthTablePracticeGridPane truthTablePracticePane;

    public TruthTablePractice (WffTree _wffTree) {
        this.wffTree = _wffTree;
        this.truthTable = new TruthTable(_wffTree);
        this.truthTablePracticePane = new TruthTablePracticeGridPane(this.truthTable);
        this.initializeFx();
        Controller.DATA_BUS.throwUpdate(new PracticePaneUpdate(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().add(this.truthTablePracticePane);
    }

    @Override
    public boolean getResult() {
        return this.truthTablePracticePane.getResult();
    }

    @Override
    public void setUserAnswer(Object _answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}