package com.flat.models.fx;

import com.flat.models.json.menubar.JsonMenuBar;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FxMenuBarData {
    private static Text file = new Text("File");
    private static Text resetView = new Text("Reset View");
    private static Text settings = new Text("Settings");
    private static Text exit = new Text("Exit");
    private static Text export = new Text("Export");
    private static Text exportAsLatex = new Text("Export as LaTeX(.tex");
    private static Text latexTruthTable = new Text("LaTeX Truth Table");
    private static Text latexParseTree = new Text("LaTeX Parse Tree");
    private static Text latexTruthTree = new Text("LaTeX Truth Tree");
    private static Text exportAsPdf = new Text("Export as Pdf(.pdf");
    private static Text pdfLatexTruthTable = new Text("LaTeX Truth Table");
    private static Text pdfLatexParseTree = new Text("LaTeX Parse Tree");
    private static Text pdfLatexTruthTree = new Text("LaTeX Truth Tree");
    private static Text help = new Text("Help");
    private static Text about = new Text("About");

    public static void injectData(JsonMenuBar _jsonMenu) {
        FxMenuBarData.file.setText(_jsonMenu.getFileMenu().getFile().getString());
        FxMenuBarData.resetView.setText(_jsonMenu.getFileMenu().getResetViewMenuItem().getReset().getString());
        FxMenuBarData.settings.setText(_jsonMenu.getFileMenu().getSettingsMenuItem().getSettings().getString());
        FxMenuBarData.exit.setText(_jsonMenu.getFileMenu().getExitMenuItem().getExit().getString());
        FxMenuBarData.export.setText(_jsonMenu.getExportMenu().getExport().getString());
        FxMenuBarData.exportAsLatex.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getExportAsLatex().getString());
        FxMenuBarData.latexTruthTable.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexTruthTableMenuItem().getLatexTruthTable().getString());
        FxMenuBarData.latexParseTree.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexParseTreeMenuItem().getLatexParseTree().getString());
        FxMenuBarData.latexTruthTree.setText(_jsonMenu.getExportMenu().getExportAsLatexMenu().getLatexTruthTreeMenuItem().getLatexTruthTree().getString());
        FxMenuBarData.exportAsPdf.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getExportAsPdf().getString());
        FxMenuBarData.pdfLatexTruthTable.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexTruthTableMenuItem().getLatexTruthTable().getString());
        FxMenuBarData.pdfLatexParseTree.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexParseTreeMenuItem().getLatexParseTree().getString());
        FxMenuBarData.pdfLatexTruthTree.setText(_jsonMenu.getExportMenu().getExportAsPdfMenu().getLatexTruthTreeMenuItem().getLatexTruthTree().getString());
        FxMenuBarData.help.setText(_jsonMenu.getHelpMenu().getHelp().getString());
        FxMenuBarData.about.setText(_jsonMenu.getHelpMenu().getAboutMenuItem().getAbout().getString());
    }

    public static Text getFile() {
        return file;
    }

    public static void setFile(Text file) {
        FxMenuBarData.file = file;
    }

    public static Text getResetView() {
        return resetView;
    }

    public static void setResetView(Text resetView) {
        FxMenuBarData.resetView = resetView;
    }

    public static Text getSettings() {
        return settings;
    }

    public static void setSettings(Text settings) {
        FxMenuBarData.settings = settings;
    }

    public static Text getExit() {
        return exit;
    }

    public static void setExit(Text exit) {
        FxMenuBarData.exit = exit;
    }

    public static Text getExport() {
        return export;
    }

    public static void setExport(Text export) {
        FxMenuBarData.export = export;
    }

    public static Text getExportAsLatex() {
        return exportAsLatex;
    }

    public static void setExportAsLatex(Text exportAsLatex) {
        FxMenuBarData.exportAsLatex = exportAsLatex;
    }

    public static Text getLatexTruthTable() {
        return latexTruthTable;
    }

    public static void setLatexTruthTable(Text latexTruthTable) {
        FxMenuBarData.latexTruthTable = latexTruthTable;
    }

    public static Text getLatexParseTree() {
        return latexParseTree;
    }

    public static void setLatexParseTree(Text latexParseTree) {
        FxMenuBarData.latexParseTree = latexParseTree;
    }

    public static Text getLatexTruthTree() {
        return latexTruthTree;
    }

    public static void setLatexTruthTree(Text latexTruthTree) {
        FxMenuBarData.latexTruthTree = latexTruthTree;
    }

    public static Text getExportAsPdf() {
        return exportAsPdf;
    }

    public static void setExportAsPdf(Text exportAsPdf) {
        FxMenuBarData.exportAsPdf = exportAsPdf;
    }

    public static Text getPdfLatexTruthTable() {
        return pdfLatexTruthTable;
    }

    public static void setPdfLatexTruthTable(Text pdfLatexTruthTable) {
        FxMenuBarData.pdfLatexTruthTable = pdfLatexTruthTable;
    }

    public static Text getPdfLatexParseTree() {
        return pdfLatexParseTree;
    }

    public static void setPdfLatexParseTree(Text pdfLatexParseTree) {
        FxMenuBarData.pdfLatexParseTree = pdfLatexParseTree;
    }

    public static Text getPdfLatexTruthTree() {
        return pdfLatexTruthTree;
    }

    public static void setPdfLatexTruthTree(Text pdfLatexTruthTree) {
        FxMenuBarData.pdfLatexTruthTree = pdfLatexTruthTree;
    }

    public static Text getHelp() {
        return help;
    }

    public static void setHelp(Text help) {
        FxMenuBarData.help = help;
    }

    public static Text getAbout() {
        return about;
    }

    public static void setAbout(Text about) {
        FxMenuBarData.about = about;
    }

}