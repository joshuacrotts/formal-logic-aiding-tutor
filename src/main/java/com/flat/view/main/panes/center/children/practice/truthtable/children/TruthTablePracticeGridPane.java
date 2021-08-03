package com.flat.view.main.panes.center.children.practice.truthtable.children;

import com.flat.view.main.panes.center.children.practice.truthtable.children.children.TruthTablePracticeTextField;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TruthTable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTablePracticeGridPane extends GridPane {
    private TruthTable truthTable;

    public TruthTablePracticeGridPane (TruthTable _truthTable) {
        this.truthTable = _truthTable;
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setChildrenFx();
    }

    private void setThisFx () {
        this.addChildren();
        super.setAlignment(Pos.CENTER);
        super.setHgap(5);
        super.setVgap(5);
    }

    private void addChildren () {
        truthTable.getHeaders().forEach(header -> {
            Text headerText = new Text(header.getText());
            super.add(headerText, header.getColumn(), 0);
            int rowCount = 0;
            TruthTablePracticeTextField elt;
            for (int i = 0; i < header.getElements().size(); i++) {
                elt = new TruthTablePracticeTextField(header.getElements().get(i).getTruthValue());
                super.add(elt, header.getColumn(), i + 1);
            }
         });
    }

    private void setChildrenFx () {
        super.getChildren().forEach(child -> {
            GridPane.setHalignment(child, HPos.CENTER);
            GridPane.setValignment(child, VPos.CENTER);
            GridPane.setHgrow(child, Priority.ALWAYS);
        });
    }

    public boolean getResult () {
        boolean result = true;
        for (Node child : super.getChildren()) {
            if (child instanceof TruthTablePracticeTextField)
                    result = ((TruthTablePracticeTextField)child).checkAnswer() && result;
        }
        return result;
    }

}