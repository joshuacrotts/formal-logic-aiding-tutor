package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyequivalentdeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicallyEquivalentDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicallyEquivalentDeterminerPrompt () {
        super(
                "Determine if the following well-formed formulas are logically equivalent.",
                "Two formulas are logically equivalent if the final values of their truth tables are equivalent. Two truth trees are equivalent if, when combined with a biconditional then negated, results in all branches being closed."
        );
    }

}