package com.flat.view.main.panes.right.children.selection.children.practiceprompt.boundvariabledetector;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BoundVariableDetectorPrompt extends PracticePrompt {

    public BoundVariableDetectorPrompt () {
        super(
                "Find all bound variables in the following well-formed formula.",
                "A variable is bound in a first-order predicate logic formula if there is a quantifier that binds it. In other words, the variable is in the scope of a quantifier and that quantifier's variable matches the variable that we are looking for.");
    }

}