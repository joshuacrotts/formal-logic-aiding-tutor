package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicallyimplieddeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicallyImpliedDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicallyImpliedDeterminerPrompt () {
        super(
                "Determine if the following well-formed formulas are logically implied.",
                "One formula logically implies the other if, when combining the formulas with an implication, there is no model in which the antecedent is true and the consequent is false."
        );
    }

}