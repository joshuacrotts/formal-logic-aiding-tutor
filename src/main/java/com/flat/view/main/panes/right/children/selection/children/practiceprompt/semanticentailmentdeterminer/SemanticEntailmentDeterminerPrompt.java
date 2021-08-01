package com.flat.view.main.panes.right.children.selection.children.practiceprompt.semanticentailmentdeterminer;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.truthsubmit.PracticePromptTruthSubmit;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SemanticEntailmentDeterminerPrompt extends PracticePromptTruthSubmit {

    public SemanticEntailmentDeterminerPrompt () {
        super(
                " Determine if the following well-formed formula semantically entails the other.",
                " One formula semantically entails another if one logically implies the other and they are not equivalent. Both formulas cannot logically imply each other."
        );
    }

}