package com.flat.view.main.panes.right.children.selection.children.practiceprompt.opensentencedeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class OpenSentenceDeterminerPrompt extends PracticePromptTruthSubmit {

    public OpenSentenceDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is open.",
                "A first-order predicate logic formula is open if it contains at least one free variable."
        );
    }

}