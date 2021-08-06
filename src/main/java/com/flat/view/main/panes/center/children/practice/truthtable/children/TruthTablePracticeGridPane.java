package com.flat.view.main.panes.center.children.practice.truthtable.children;

import com.flat.view.main.panes.center.children.practice.truthtable.children.children.TruthTablePracticeTextField;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableElement;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableHeader;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TruthTable;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.HorizontalTruthTableSeparator;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.TruthTableHeaderTextVBox;
import com.flat.view.main.panes.center.children.solver.truthtable.listener.children.TruthTableTextVBox;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
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
            super.add(new TruthTableHeaderTextVBox(header), header.getColumn(), 0);
            if (header.getType() != TableHeader.Type.VERTICAL) {
                TableElement curElt;
                for (int i = 0; i < header.getElements().size(); i++) {
                    curElt = header.getElements().get(i);
                    if (curElt.getType() == TableElement.Type.REGULAR)
                    super.add(new TruthTableTextVBox(curElt, new TruthTablePracticeTextField(curElt.getTruthValue())), header.getColumn(), i + 1);
                }
            }
         });
        super.add(new HorizontalTruthTableSeparator(), 0, 1, this.truthTable.getHeaders().size(), 1);
    }

    public boolean getResult () {
        boolean result = true;
        for (Node child : super.getChildren()) {
            if (child instanceof TruthTableTextVBox)
                    result = ((TruthTableTextVBox)child).getPracticeTextField().checkAnswer() && result;
        }
        return result;
    }

}