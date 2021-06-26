package com.flat.algorithms;

import com.flat.algorithms.models.NDWffTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 */
public class PdfNaturalDeductionPrinter extends PdfPrinter {

    /**
     * Template location to read from.
     */
    private static final String TEX_ND_TEMPLATE = "src/main/resources/tex_natural_deduction_template.tex";

    /**
     *
     */
    private final ArrayList<NDWffTree> ndArgs;

    public PdfNaturalDeductionPrinter(ArrayList<NDWffTree> _ndArgs, String _outputFile) {
        super(null, _outputFile);
        this.ndArgs = _ndArgs;
    }

    /**
     * Outputs the parse tree to a .tex file. The preamble information/template data is
     * copied to the output file first, then we recursively traverse the TruthTree object
     * calling the getTexLiteralCommand() methods on each node.
     */
    public void outputToFile() {
        try {
            this.setBufferedReader(new BufferedReader(new FileReader(TEX_ND_TEMPLATE)));
            StringBuilder httpTex = new StringBuilder();

            // First copy the template over.
            int ch = this.getBufferedReader().read();
            while (ch != -1) {
                httpTex.append((char) ch);
                ch = this.getBufferedReader().read();
            }
            this.getBufferedReader().close();

            // Append the table code to this request.
            httpTex.append(this.getTexNaturalDeduction());
            httpTex.append("\n\\end{logicproof}\n}\\end{document}\n");

            // Build the URL and HTTP request.
            String texURL = "https://latex.ytotech.com/builds/sync";
            PdfPrinter.downloadFile(texURL, this.getOutputFile(), httpTex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    private String getTexNaturalDeduction() {
        StringBuilder sb = new StringBuilder();
        for (NDWffTree ndArg : this.ndArgs) {
            sb.append(ndArg.getWffTree().getTexCommand());
            sb.append(" & ");
            sb.append(ndArg.getDerivationStep().getTexCommand());
            if (!ndArg.getDerivedParentIndices().isEmpty()) {
                sb.append(", ");
                for (int i = 0; i < ndArg.getDerivedParentIndices().size() - 1; i++) {
                    sb.append(ndArg.getDerivedParentIndices().get(i));
                    sb.append(", ");
                }
                sb.append(ndArg.getDerivedParentIndices().get(ndArg.getDerivedParentIndices().size() - 1));
            }
            sb.append("\\\\\n");
        }
        sb.append("\\therefore ");
        sb.append(this.ndArgs.get(this.ndArgs.size() - 1).getWffTree().getTexCommand());
        sb.append("\\hfill\\blacksquare\n");
        return sb.toString();
    }
}
