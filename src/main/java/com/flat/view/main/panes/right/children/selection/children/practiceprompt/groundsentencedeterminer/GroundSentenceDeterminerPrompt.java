package com.flat.view.main.panes.right.children.selection.children.practiceprompt.groundsentencedeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class GroundSentenceDeterminerPrompt extends PracticePromptTruthSubmit {

    public GroundSentenceDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is ground.",
                "A first-order predicate logic formula is ground if it does not contain any variables. In other words, all predicates contain only constants."
        );
    }

}