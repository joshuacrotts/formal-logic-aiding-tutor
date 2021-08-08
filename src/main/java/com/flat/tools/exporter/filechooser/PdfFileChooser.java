package com.flat.tools.exporter.filechooser;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfFileChooser {
    private FileChooser fileChooser = new FileChooser();
    private ExtensionFilter extensionFilter = new ExtensionFilter("pdf (*.pdf)", "*.pdf");

    public PdfFileChooser () {
        this.initializeFx();
    }

    private void  initializeFx () {
        this.fileChooser.setTitle("Export to Pdf (.pdf)");
        this.fileChooser.getExtensionFilters().add(this.extensionFilter);
        this.fileChooser.setSelectedExtensionFilter(this.extensionFilter);
    }

    // Getters for object's attributes.
    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public ExtensionFilter getExtensionFilter() {
        return extensionFilter;
    }

    // Setters for object's attributes.
    public void setFileChooser(FileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public void setExtensionFilter(ExtensionFilter extensionFilter) {
        this.extensionFilter = extensionFilter;
    }

}