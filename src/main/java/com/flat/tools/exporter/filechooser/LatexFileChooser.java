package com.flat.tools.exporter.filechooser;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexFileChooser {
    private FileChooser fileChooser = new FileChooser();
    private ExtensionFilter extensionFilter = new ExtensionFilter("LaTeX (*.tex)", "*.tex");

    public LatexFileChooser () {
        this.initializeFx();
    }

    private void  initializeFx () {
        this.fileChooser.setTitle("Export to LaTeX (.tex)");
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