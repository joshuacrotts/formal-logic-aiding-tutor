package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicalfalsehooddeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicalFalsehoodDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicalFalsehoodDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is a logical falsehood.",
                "A formula is a logical falsehood if the truth table is F in all models. A truth tree is a falsehood if it has all closed branches."
        );
    }

}