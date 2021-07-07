package com.flat.view.main.menubar.menus.export;

import com.flat.view.viewdata.menubar.MenuBarData;
import com.flat.view.main.menubar.items.export.pdf.PdfLatexParseTreeMenuItem;
import com.flat.view.main.menubar.items.export.pdf.PdfLatexTruthTableMenuItem;
import com.flat.view.main.menubar.items.export.pdf.PdfLatexTruthTreeMenuItem;
import javafx.scene.control.Menu;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ExportAsPdfMenu extends Menu {
    private final PdfLatexTruthTableMenuItem pdfLatexTruthTableMenuItem = new PdfLatexTruthTableMenuItem();
    private final PdfLatexParseTreeMenuItem pdfLatexParseTreeMenuItem = new PdfLatexParseTreeMenuItem();
    private final PdfLatexTruthTreeMenuItem pdfLatexTruthTreeMenuItem = new PdfLatexTruthTreeMenuItem();

    public ExportAsPdfMenu() {
        super.textProperty().bind(MenuBarData.getExportAsPdf().textProperty());
        super.getItems().addAll(this.pdfLatexTruthTableMenuItem, this.pdfLatexParseTreeMenuItem, this.pdfLatexTruthTreeMenuItem);
    }

}