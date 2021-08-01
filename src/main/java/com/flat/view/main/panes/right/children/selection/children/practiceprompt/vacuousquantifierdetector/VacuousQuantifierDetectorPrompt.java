package com.flat.view.main.panes.right.children.selection.children.practiceprompt.vacuousquantifierdetector;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class VacuousQuantifierDetectorPrompt extends PracticePrompt {

    public VacuousQuantifierDetectorPrompt () {
        super(
                "Find all the vacuous quantifiers in the following first-order predicate logic formula.",
                "A quantifier in a first-order predicate logic formula is vacuous if it does not bind any variables in its scope. In other words, if a quantifier is the main operator of a formula, then that formula does not contain the same variable that the quantifier uses.");
    }

}