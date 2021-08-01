package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyconsistentdeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicallyConsistentDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicallyConsistentDeterminerPrompt () {
        super(
                "Determine if the following well-formed formulas are logically consistent.",
                "Two formulas are consistent if there is one model in which they are both true. In other words, if we create a biconditional between the two, and check the consistency branch (where both operands are affirmed), at least one branch is open."
        );
    }

}