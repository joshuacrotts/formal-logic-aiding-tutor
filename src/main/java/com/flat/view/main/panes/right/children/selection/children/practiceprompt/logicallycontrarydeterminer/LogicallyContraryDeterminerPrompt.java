package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallycontrarydeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicallyContraryDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicallyContraryDeterminerPrompt () {
        super(
                "Determine if the following well-formed formulas are logically contrary.",
                "Two formulas are logically contrary if the consistency branch (where the bicond operands are affirmed) is closed, but the inconsistency branch (where the bicond operands are negated) must have at least one branch open. In other words, there is no model where both are true but there's at least one where they are false."
        );
    }

}