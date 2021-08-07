package com.flat.view.main.panes.right.children.selection.children.practiceprompt.treedeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.submit.PracticePromptSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeDeterminerPrompt extends PracticePromptSubmit {

    public TreeDeterminerPrompt () {
        super(
                "Label each leaf node/branch as open or closed.",
                "Remember that a branch is closed if a contradiction exists on that branch. For instance, if we have a wff P, there must exist ~P somewhere prior in that branch."
        );
    }

}