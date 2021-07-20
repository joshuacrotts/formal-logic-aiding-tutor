package com.flat.view.data.menubar;

import com.flat.models.json.language.JsonLanguage;
import com.flat.models.json.menubar.JsonMenuBar;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MenuBarData {
    private final static Text file = new Text("File");
    private final static Text resetView = new Text("Reset View");
    private final static Text settings = new Text("Settings");
    private final static Text exit = new Text("Exit");
    private final static Text export = new Text("Export");
    private final static Text exportAsLatex = new Text("Export as LaTeX(.tex");
    private final static Text latexTruthTable = new Text("LaTeX Truth Table");
    private final static Text latexParseTree = new Text("LaTeX Parse Tree");
    private final static Text latexTruthTree = new Text("LaTeX Truth Tree");
    private final static Text exportAsPdf = new Text("Export as Pdf(.pdf");
    private final static Text pdfLatexTruthTable = new Text("LaTeX Truth Table");
    private final static Text pdfLatexParseTree = new Text("LaTeX Parse Tree");
    private final static Text pdfLatexTruthTree = new Text("LaTeX Truth Tree");
    private final static Text help = new Text("Help");
    private final static Text about = new Text("About");

    public static void injectData(JsonLanguage _jsonLanguage, JsonMenuBar _jsonMenu) {
        file.setText(_jsonMenu.getFileMenu().getFile().getString());
        resetView.setText(_jsonMenu.getFileMenu().getResetViewMenuItem().getReset().getString());
        settings.setText(_jsonMenu.getFileMenu().getSettingsMenuItem().getSettings().getString());
        exit.setText(_jsonMenu.getFileMenu().getExitMenuItem().getExit().getString());
        export.setText(_jsonMenu.getExportMenu().getExport().getString());
        exportAsLatex.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getExportAsLatex().getString());
        latexTruthTable.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexTruthTableMenuItem().getLatexTruthTable().getString());
        latexParseTree.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexParseTreeMenuItem().getLatexParseTree().getString());
        latexTruthTree.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexTruthTreeMenuItem().getLatexTruthTree().getString());
        exportAsPdf.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getExportAsPdf().getString());
        pdfLatexTruthTable.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexTruthTableMenuItem().getLatexTruthTable().getString());
        pdfLatexParseTree.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexParseTreeMenuItem().getLatexParseTree().getString());
        pdfLatexTruthTree.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexTruthTreeMenuItem().getLatexTruthTree().getString());
        help.setText(_jsonMenu.getHelpMenu().getHelp().getString());
        about.setText(_jsonMenu.getHelpMenu().getAboutMenuItem().getAbout().getString());
    }

    // Getters for object's attributes.
    public final static Text getFile() {
        return file;
    }

    public final static Text getResetView() {
        return resetView;
    }

    public final static Text getSettings() {
        return settings;
    }

    public final static Text getExit() {
        return exit;
    }

    public final static Text getExport() {
        return export;
    }

    public final static Text getExportAsLatex() {
        return exportAsLatex;
    }

    public final static Text getLatexTruthTable() {
        return latexTruthTable;
    }

    public final static Text getLatexParseTree() {
        return latexParseTree;
    }

    public final static Text getLatexTruthTree() {
        return latexTruthTree;
    }

    public final static Text getExportAsPdf() {
        return exportAsPdf;
    }

    public final static Text getPdfLatexTruthTable() {
        return pdfLatexTruthTable;
    }

    public final static Text getPdfLatexParseTree() {
        return pdfLatexParseTree;
    }

    public final static Text getPdfLatexTruthTree() {
        return pdfLatexTruthTree;
    }

    public final static Text getHelp() {
        return help;
    }

    public final static Text getAbout() {
        return about;
    }

}