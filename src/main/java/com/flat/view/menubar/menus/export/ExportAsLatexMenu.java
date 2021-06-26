package com.flat.view.menubar.menus.export;

import com.flat.models.fx.FxMenuBarData;
import com.flat.view.menubar.items.export.latex.LatexParseTreeMenuItem;
import com.flat.view.menubar.items.export.latex.LatexTruthTableMenuItem;
import com.flat.view.menubar.items.export.latex.LatexTruthTreeMenuItem;
import javafx.scene.control.Menu;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportAsLatexMenu extends Menu {
    private LatexTruthTableMenuItem latexTruthTableMenuItem = new LatexTruthTableMenuItem();
    private LatexParseTreeMenuItem latexParseTreeMenuItem = new LatexParseTreeMenuItem();
    private LatexTruthTreeMenuItem latexTruthTreeMenuItem = new LatexTruthTreeMenuItem();

    public ExportAsLatexMenu() {
        super.textProperty().bind(FxMenuBarData.getExportAsLatex().textProperty());
        super.getItems().addAll(this.latexTruthTableMenuItem, this.latexParseTreeMenuItem, this.latexTruthTreeMenuItem);
    }

}