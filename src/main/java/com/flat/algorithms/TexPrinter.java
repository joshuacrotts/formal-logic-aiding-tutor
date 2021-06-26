package com.flat.algorithms;

import com.flat.models.treenode.WffTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public abstract class TexPrinter {

    /**
     * Truth tree to print to the output file.
     */
    private final WffTree wffTree;

    /**
     * Output file to print to.
     */
    private final String outputFile;

    /**
     * BufferedWriter object.
     */
    private BufferedWriter writer;

    /**
     * BufferedReader object to read the template in.
     */
    private BufferedReader reader;

    public TexPrinter(WffTree _tree, String _outputFile) {
        this.wffTree = _tree;
        this.outputFile = _outputFile;
    }

    /**
     * Removes the math mode environment from a string in TeX.
     *
     * @param _s - String to embed in the math mode removal command.
     * @return String inside of \mathrm{...}.
     */
    public static String removeMathMode(String _s) {
        return "\\mathrm{" + _s + "}";
    }

    /**
     * Outputs the algorithm or whatever subclass extends this to the output file.
     */
    public abstract void outputToFile();

    protected BufferedReader getBufferedReader() {
        return this.reader;
    }

    protected void setBufferedReader(BufferedReader _reader) {
        this.reader = _reader;
    }

    protected BufferedWriter getBufferedWriter() {
        return this.writer;
    }

    protected void setBufferedWriter(BufferedWriter _writer) {
        this.writer = _writer;
    }

    protected String getOutputFile() {
        return this.outputFile;
    }

    protected WffTree getWffTree() {
        return this.wffTree;
    }
}
