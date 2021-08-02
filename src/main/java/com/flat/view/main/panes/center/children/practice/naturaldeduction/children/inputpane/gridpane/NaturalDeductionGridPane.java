package com.flat.view.main.panes.center.children.practice.naturaldeduction.children.inputpane.gridpane;

import com.flat.algorithms.models.NDWffTree;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionGridPane extends GridPane {
    private int lineCount = 0;

    public NaturalDeductionGridPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setHgap(20);
        super.setAlignment(Pos.CENTER);
    }

    public void addProofLine (NDWffTree _ndWff) {
        super.add(new Text(String.valueOf(this.lineCount + 1) + "."), 0, this.lineCount);
        super.add(new Text(_ndWff.getWffTree().getStringRep()), 1, this.lineCount);
        super.add(new Text(_ndWff.getDerivationStep().toString()), 2, this.lineCount);
        if (!_ndWff.getDerivedParentIndices().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < _ndWff.getDerivedParentIndices().size() - 2; i++) {
                sb.append(i).append(", ");
            }
            sb.append(_ndWff.getDerivedParentIndices().get(_ndWff.getDerivedParentIndices().size() - 1));
            super.add(new Text(sb.toString()), 3, this.lineCount);
        }
        else {
            super.add(new Text(""), 3, this.lineCount);
        }
        this.lineCount++;
    }

    public void clear () {
        this.lineCount = 0;
        super.getChildren().clear();
    }

}