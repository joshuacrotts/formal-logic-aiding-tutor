package com.flat.view.main.panes.center.children.solver.truthtable.listener.children;

import com.flat.view.main.panes.center.children.solver.truthtable.base.tablelayout.TableHeader;
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
public class TruthTableHeaderTextVBox extends VBox {
    private TableHeader tableHeader;

    public TruthTableHeaderTextVBox (TableHeader _tableHeader) {
        this.tableHeader = _tableHeader;
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setAlignment(Pos.CENTER);
        if (null != this.tableHeader.getType()) switch (this.tableHeader.getType()) {
            case PARENTHETICAL_OPEN:
            case PARENTHETICAL_CLOSE:
                super.getChildren().add(new TruthTableText(this.tableHeader.getText()));
                GridPane.setFillWidth(this, Boolean.FALSE);
                GridPane.setMargin(this, new Insets(0));
                GridPane.setConstraints(this, this.tableHeader.getColumn(), 0);
                break;
            case REGULAR:
                super.getChildren().add(new TruthTableText(this.tableHeader.getText()));
                GridPane.setMargin(this, new Insets(0, 5, 0, 5));
                GridPane.setConstraints(this, this.tableHeader.getColumn(), 0);
                break;
            case VERTICAL:
                super.getChildren().add(new VerticalTruthTableSeparator());
                GridPane.setMargin(this, new Insets(0, 5, 5 , 5));
                GridPane.setConstraints(this, this.tableHeader.getColumn(), 0, 1, this.tableHeader.getElements().size() + 1);
                break;
            default:
                break;
        }
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);
    }

}