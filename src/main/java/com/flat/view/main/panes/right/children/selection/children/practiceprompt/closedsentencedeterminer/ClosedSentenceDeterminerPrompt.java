package com.flat.view.main.panes.right.children.selection.children.practiceprompt.closedsentencedeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ClosedSentenceDeterminerPrompt extends PracticePromptTruthSubmit {

    public ClosedSentenceDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is closed.",
                "A first-order predicate logic formula is closed if it does not contain any free variables. Another way of phrasing it is to say that all variables are bound."
        );
    }

}