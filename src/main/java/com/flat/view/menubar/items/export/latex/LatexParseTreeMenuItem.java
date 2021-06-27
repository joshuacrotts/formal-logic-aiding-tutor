package com.flat.view.menubar.items.export.latex;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LatexParseTreeMenuItem extends MenuItem {

    public LatexParseTreeMenuItem() {
        super.textProperty().bind(FxMenuBarData.getPdfLatexParseTree().textProperty());
    }

}