package com.flat.algorithms;

import com.flat.algorithms.models.NDWffTree;

import java.util.ArrayList;

public class TexNaturalDeductionPrinter extends TexPrinter {

    /**
     * Template location to read from.
     */
    private static final String TEX_ND_TEMPLATE = "main/resources/tex_natural_deduction_template.tex";

    /**
     *
     */
    private final ArrayList<NDWffTree> ND_ARGS;

    public TexNaturalDeductionPrinter(ArrayList<NDWffTree> _ndArgs, String _outputFile) {
        super(null, _outputFile);
        this.ND_ARGS = _ndArgs;
    }

    @Override
    public void outputToFile() {

    }
}
