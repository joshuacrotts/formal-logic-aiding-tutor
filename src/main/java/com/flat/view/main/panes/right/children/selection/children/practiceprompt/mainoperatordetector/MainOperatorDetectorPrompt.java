package com.flat.view.main.panes.right.children.selection.children.practiceprompt.mainoperatordetector;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MainOperatorDetectorPrompt extends PracticePrompt {

    public MainOperatorDetectorPrompt () {
        super(
                "Determine what the main operator is in the following well-formed formula.",
                "The main operator of a well-formed formula is the first operator evaluated. When choosing the operator, ask yourself which one allows you to determine its truth value."
        );
    }

}