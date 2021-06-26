package com.flat.algorithms;

import com.flat.algorithms.models.TruthTree;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 */
public class PdfTruthTreePrinter extends PdfPrinter {

    /**
     * Template location to read from.
     */
    private static final String TEX_TREE_TEMPLATE = "src/main/resources/tex_truth_tree_template.tex";

    /**
     * Truth tree to print.
     */
    private final TruthTree truthTree;

    public PdfTruthTreePrinter(TruthTree _tree, String _outputFile) {
        super(_tree.getWff(), _outputFile);
        this.truthTree = _tree;
    }

    /**
     * Outputs the truth tree to a .tex file. The preamble information/template data is
     * copied to the output file first, then we recursively traverse the TruthTree object
     * calling the getTexLiteralCommand() methods on each node.
     */
    public void outputToFile() {
        try {
            this.setBufferedReader(new BufferedReader(new FileReader(TEX_TREE_TEMPLATE)));
            StringBuilder httpTex = new StringBuilder();

            // First copy the template over.
            int ch = this.getBufferedReader().read();
            while (ch != -1) {
                httpTex.append((char) ch);
                ch = this.getBufferedReader().read();
            }
            this.getBufferedReader().close();

            // Append the table code to this request.
            httpTex.append(this.truthTree.getTexTree());
            httpTex.append("\n\\end{forest}\n\\end{document}\n");

            // Build the URL and HTTP request.
            String texURL = "https://latex.ytotech.com/builds/sync";
            PdfPrinter.downloadFile(texURL, this.getOutputFile(), httpTex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
