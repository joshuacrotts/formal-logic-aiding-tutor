package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.submit;

import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.extensions.submit.buttons.PracticeSubmitButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePromptSubmit extends PracticePrompt {

    public PracticePromptSubmit(String _prompt, String _info) {
        super(_prompt, _info);
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().add(new PracticeSubmitButton());
    }

}