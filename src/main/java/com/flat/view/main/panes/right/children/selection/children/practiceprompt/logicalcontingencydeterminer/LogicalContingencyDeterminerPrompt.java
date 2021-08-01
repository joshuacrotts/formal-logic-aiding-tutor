package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicalcontingencydeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicalContingencyDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicalContingencyDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is a logical contingency.",
                "A formula is logically contingent if there is at least one row in the truth table that is true and one that is false. A logical contingency is neither a falsehood nor a tautology."
        );
    }

}