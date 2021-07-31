package com.flat.view.main.panes.right.children.selection.children.practiceprompt.listener;

import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.PracticeWrapperPane;
import com.flat.view.main.panes.right.children.selection.children.practiceprompt.mainoperatordetector.MainOperatorDetectorPrompt;
import com.flat.view.main.panes.right.children.top.practicetoggle.pane.events.PracticeModeToggle;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticeWrapperPaneListener implements DataListener, EventListener {
    private PracticeWrapperPane wrapperPane;
    private boolean practiceToggle = false;

    public PracticeWrapperPaneListener (PracticeWrapperPane _wrapperPane) {
        this.wrapperPane = _wrapperPane;
    }

    @Override
    public void handleUpdate(Update _update) {
        switch(_update.getType()) {
            case PRACTICE_MODE_TOGGLE:
                this.setPracticeToggle(((PracticeModeToggle)_update).isPractice());
                break;
        }
    }

    @Override
    public void catchEvent(Event _event) {
        switch(_event.getType()) {
            case UPDATE_MAIN_OPERATOR_DETECTOR_PRACTICE:
                this.wrapperPane.setContent(new MainOperatorDetectorPrompt());
                break;
            case CLEAR_LOGIC_VISUALS:
                this.wrapperPane.setContent(null);
        }
    }

    private void setPracticeToggle (boolean _boolean) {
        this.practiceToggle = _boolean;
        if (!this.practiceToggle)
            this.wrapperPane.setContent(null);
    }

}