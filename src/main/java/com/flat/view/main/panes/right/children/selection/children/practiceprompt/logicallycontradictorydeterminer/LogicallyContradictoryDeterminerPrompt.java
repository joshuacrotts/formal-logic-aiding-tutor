package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallycontradictorydeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicallyContradictoryDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicallyContradictoryDeterminerPrompt () {
        super(
                "Determine if the following well-formed formulas are logically contradictory.",
                "Two formulas are logically contradictory if they have the opposite truth values in the main operator of their truth table. For the truth tree, if we combine the formulas with a biconditional, it should result in every branch closing."
        );
    }

}