package com.flat.view.main.menubar.items.export.latex;

import com.flat.view.viewdata.menubar.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LatexParseTreeMenuItem extends MenuItem {

    public LatexParseTreeMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexParseTree().textProperty());
    }

}