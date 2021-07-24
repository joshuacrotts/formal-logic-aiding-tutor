package com.flat.view.main.panes.left.children.logicsymbolspane;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.labels.PredicateLabel;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.labels.PropositionalLabel;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbolsPane extends GridPane {
    private PropositionalLabel propositional = new PropositionalLabel();
    private PredicateLabel predicate = new PredicateLabel();
    private int max_width = 4;
    private int cur_rows = 0;

    public LogicSymbolsPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.setStyle("-fx-background-color: yellow");
        super.setVgap(10);
        super.setHgap(10);
        this.addPropositionalLabel();
        this.cur_rows++;
        this.addPropositionalButtons();
        this.cur_rows++;
        this.addPredicateLabel();
        this.cur_rows++;
        this.addPredicateButtons();
    }

    private boolean validColumn (int _columnCount) {
        return !(_columnCount % max_width == 0 && _columnCount != 0);
    }

    private void addPropositionalLabel () {
        this.setLabelFx(this.propositional);
        super.getChildren().add(this.propositional);
    }

    private void addPropositionalButtons () {/*
        int columnCount = 0;
        LogicButton curButton;
        for (String key : Controller.getMAPPED_SYMBOLS().getType(KeyedLogicSymbol.Type.PROPOSITIONAL).keySet()) {
            curButton = new LogicButton(key, Controller.getMAPPED_SYMBOLS().getValue(KeyedLogicSymbol.Type.PROPOSITIONAL, key));
            this.setButtonFx(curButton, columnCount % max_width, this.cur_rows);
            super.getChildren().add(curButton);
            columnCount++;
            if (!validColumn(columnCount))
                this.cur_rows++;
        }*/
    }

    private void addPredicateLabel () {
        this.setLabelFx(this.predicate);
        super.getChildren().add(this.predicate);
    }

    private void addPredicateButtons () {/*
        int columnCount = 1;
        LogicButton curButton;
        for (String key : Controller.getMAPPED_SYMBOLS().getType(KeyedLogicSymbol.Type.PREDICATE).keySet()) {
            curButton = new LogicButton(key, Controller.getMAPPED_SYMBOLS().getValue(KeyedLogicSymbol.Type.PREDICATE, key));
            this.setButtonFx(curButton, columnCount % max_width, this.cur_rows);
            super.getChildren().add(curButton);
            columnCount++;
            if (!validColumn(columnCount))
                this.cur_rows++;
        }*/
    }

    private void setLabelFx (Node _node) {
        GridPane.setConstraints(_node, 0, this.cur_rows);
        GridPane.setColumnSpan(_node, this.max_width);
        this.setThisChildrenDefaultFx(_node);
    }

    private void setButtonFx (LogicButton _button, int _column, int _row) {
        GridPane.setConstraints(_button, _column, _row);
        this.setThisChildrenDefaultFx(_button);
    }

    private void setThisChildrenDefaultFx (Node _node) {
        GridPane.setHgrow(_node, Priority.ALWAYS);
        GridPane.setVgrow(_node, Priority.ALWAYS);
        GridPane.setHalignment(_node, HPos.CENTER);
    }

}