package com.flat.tools.exporter;

import com.flat.algorithms.PdfParseTreePrinter;
import com.flat.algorithms.PdfTruthTreePrinter;
import com.flat.algorithms.TexParseTreePrinter;
import com.flat.algorithms.TexTruthTreePrinter;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PdfTruthTablePrinter;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.algorithms.propositional.TexTablePrinter;
import com.flat.controller.Controller;
import com.flat.models.treenode.WffTree;
import com.flat.tools.exporter.filechooser.LatexFileChooser;
import com.flat.tools.exporter.filechooser.PdfFileChooser;
import com.flat.tools.exporter.listener.ViewExporterListener;
import java.io.File;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ViewExporter {
    private File file = null;
    private WffTree wffTree = null;

    public ViewExporter () {
        Controller.EVENT_BUS.addListener(new ViewExporterListener(this));
    }

    private File newLatexFile () {
        this.file = null;
        this.file = new LatexFileChooser().getFileChooser().showSaveDialog(Controller.STAGE);
        return this.file;
    }

    private File newPdfFile () {
        this.file = null;
        this.file = new PdfFileChooser().getFileChooser().showSaveDialog(Controller.STAGE);
        return this.file;
    }

    public void exportPdfTruthTree () {
        if (this.newPdfFile() != null)
            new PdfTruthTreePrinter((this.wffTree.isPropositionalWff()) ? new PropositionalTruthTreeGenerator(this.wffTree).getTruthTree() : new PredicateTruthTreeGenerator(this.wffTree).getTruthTree(), this.file.getAbsolutePath()).outputToFile();
    }

    public void exportPdfTruthTable () {
        if (this.newPdfFile() != null)
            new PdfTruthTablePrinter(this.wffTree, this.file.getAbsolutePath()).outputToFile();
    }

    public void exportPdfParseTree () {
        if (this.newPdfFile() != null)
            new PdfParseTreePrinter(this.wffTree, this.file.getAbsolutePath()).outputToFile();
    }

    public void exportLatexTruthTree () {
        if (this.newLatexFile() != null)
            new TexTruthTreePrinter((this.wffTree.isPropositionalWff()) ? new PropositionalTruthTreeGenerator(this.wffTree).getTruthTree() : new PredicateTruthTreeGenerator(this.wffTree).getTruthTree(), this.file.getAbsolutePath()).outputToFile();
    }

    public void exportLatexTruthTable () {
        if (this.newLatexFile() != null)
            new TexTablePrinter(this.wffTree, this.file.getAbsolutePath()).outputToFile();
    }

    public void exportLatexParseTree () {
        if (this.newLatexFile() != null)
            new TexParseTreePrinter(this.wffTree, this.file.getAbsolutePath()).outputToFile();
    }

    // Getters for object's attributes.
    public File getFile() {
        return file;
    }

    public WffTree getWffTree() {
        return wffTree;
    }

    // Setters for object's attributes.
    public void setFile(File file) {
        this.file = file;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

}