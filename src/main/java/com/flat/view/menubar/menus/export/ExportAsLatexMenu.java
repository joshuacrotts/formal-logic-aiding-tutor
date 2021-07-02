package com.flat.view.menubar.menus.export;

import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.menubar.items.export.latex.LatexParseTreeMenuItem;
import com.flat.view.menubar.items.export.latex.LatexTruthTableMenuItem;
import com.flat.view.menubar.items.export.latex.LatexTruthTreeMenuItem;
import javafx.scene.control.Menu;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportAsLatexMenu extends Menu {
    private final LatexTruthTableMenuItem latexTruthTableMenuItem = new LatexTruthTableMenuItem();
    private final LatexParseTreeMenuItem latexParseTreeMenuItem = new LatexParseTreeMenuItem();
    private final LatexTruthTreeMenuItem latexTruthTreeMenuItem = new LatexTruthTreeMenuItem();

    public ExportAsLatexMenu() {
        super.textProperty().bind(MenuBarData.getExportAsLatex().textProperty());
        super.getItems().addAll(this.latexTruthTableMenuItem, this.latexParseTreeMenuItem, this.latexTruthTreeMenuItem);
    }

}