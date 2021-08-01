package com.flat.view.main.panes.right.children.selection.children.practiceprompt.freevariabledetector;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FreeVariableDetectorPrompt extends PracticePrompt {

    public FreeVariableDetectorPrompt () {
        super(
                "Find all free variables in the following well-formed formula.",
                "A variable is free in a first-order predicate logic formula if there is no quantifier that binds it. In other words, it is not in the scope of any quantifier."
        );
    }

}