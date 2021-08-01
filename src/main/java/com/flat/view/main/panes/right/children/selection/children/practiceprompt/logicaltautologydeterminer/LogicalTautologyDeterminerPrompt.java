package com.flat.view.main.panes.right.children.selection.children.practiceprompt.logicaltautologydeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicalTautologyDeterminerPrompt extends PracticePromptTruthSubmit {

    public LogicalTautologyDeterminerPrompt () {
        super(
                "Determine if the following well-formed formula is a logical tautology.",
                "A formula is a logical tautology if the truth table is T in all models. A truth tree is a tautology if its negation has all closed branches."
        );
    }

}