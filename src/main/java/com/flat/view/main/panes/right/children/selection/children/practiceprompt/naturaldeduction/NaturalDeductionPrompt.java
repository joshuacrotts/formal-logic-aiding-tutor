package com.flat.view.main.panes.right.children.selection.children.practiceprompt.naturaldeduction;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPrompt extends PracticePrompt {

    public NaturalDeductionPrompt () {
        super(
                "Prove that the following argument is valid using natural deduction.",
                "Natural deduction is a technique to prove an argument's validity. Rather than drawing a tree and figuring out which branches are open/closed, we instead try to go straight from the premises to the conclusion using intermediate steps. Any proof that eventually reaches the conclusion is correct so don't hesitate to try different things! If you get stuck, just reset the pane."
        );
    }

}