package com.flat.view.main.panes.center.children.solver.truthtable.listener.children;

import com.flat.view.main.panes.center.children.practice.truthtable.children.children.TruthTablePracticeTextField;
import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableElement;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTableTextVBox extends VBox {
    private TableElement tableElement;
    private boolean practice = false;
    private TruthTablePracticeTextField practiceTextField = null;

    public TruthTableTextVBox (TableElement _tableElement, TruthTablePracticeTextField _practiceTextField) {
        this.tableElement = _tableElement;
        this.practiceTextField = _practiceTextField;
        super.getChildren().add(_practiceTextField);
        this.practice = true;
        this.initializeFx();
    }

    public TruthTableTextVBox (TableElement _tableElement) {
        this.tableElement = _tableElement;
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        if (this.tableElement.getType() == TableElement.Type.REGULAR) {
            GridPane.setMargin(this, new Insets(5));
            if (!this.practice)
                super.getChildren().add(new TruthTableText(tableElement.getText()));
        }
        super.setAlignment(Pos.CENTER);
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);
    }

    // Getters for object's attributes.
    public TableElement getTableElement() {
        return tableElement;
    }

    public boolean isPractice() {
        return practice;
    }

    public TruthTablePracticeTextField getPracticeTextField() {
        return practiceTextField;
    }

}