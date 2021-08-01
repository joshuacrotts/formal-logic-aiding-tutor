package com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.listener;

import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.view.main.panes.center.children.practice.listener.events.PracticeResult;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.base.PracticePrompt;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePromptListener implements DataListener {
    private PracticePrompt practicePrompt;

    public PracticePromptListener (PracticePrompt _practicePrompt) {
        this.practicePrompt = _practicePrompt;
    }

    @Override
    public void handleUpdate(Update _update) {
        switch (_update.getType()) {
            case PRACTICE_RESULT:
                this.practicePrompt.getResult().setText(((PracticeResult)_update).isResult()? "Correct" : "Incorrect");
                break;
        }
    }

}