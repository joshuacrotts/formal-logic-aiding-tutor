package com.flat.view.main.menubar.items.export.latex;

import com.flat.view.viewdata.menubar.MenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LatexTruthTreeMenuItem extends MenuItem {

    public LatexTruthTreeMenuItem() {
        super.textProperty().bind(MenuBarData.getPdfLatexTruthTree().textProperty());
    }

}