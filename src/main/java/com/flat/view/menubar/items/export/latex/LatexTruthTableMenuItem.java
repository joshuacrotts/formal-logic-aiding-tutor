package com.flat.view.menubar.items.export.latex;

import com.flat.models.fx.FxMenuBarData;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LatexTruthTableMenuItem extends MenuItem {

    public LatexTruthTableMenuItem () {
        super.textProperty().bind(FxMenuBarData.getPdfLatexTruthTable().textProperty());
    }

}