package com.flat.view.main.panes.right.children.selection.children.practiceprompt.truthtable;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.submit.PracticePromptSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTablePrompt extends  PracticePromptSubmit {

    public TruthTablePrompt () {
        super(
                "Fill in the corresponding truth values for each column in the truth table.",
                "The truth table is a listing of the truth values that make up a well-formed formula. When evaluating these, go from the inner-most formulas outward. The main operator should be the last column filled."
        );
    }

}