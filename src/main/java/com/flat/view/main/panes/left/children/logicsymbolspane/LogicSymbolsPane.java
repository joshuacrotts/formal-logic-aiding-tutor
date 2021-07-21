package com.flat.view.main.panes.left.children.logicsymbolspane;

import com.flat.controller.Controller;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.logicsymbolsbutton.LogicSymbolsButton;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbolsPane extends GridPane {
    private int max_width = 4;

    public LogicSymbolsPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        this.addThisChildren();
    }

    private void addThisChildren () {
        int columnCount = 0;
        int rowCount = 0;
        for (Class <?> _key : Controller.getKEYED_SYMBOLS().getSymbols().keySet()) {
            GridPane.setConstraints(new LogicSymbolsButton(Controller.getKEYED_SYMBOLS().getValue(_key)), columnCount % max_width, rowCount);
            columnCount++;
            if (columnCount % max_width == max_width - 1)
                rowCount ++;
        }
    }

}