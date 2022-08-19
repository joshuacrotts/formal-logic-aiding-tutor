package com.flat.view.main.panes.center.children.practice.base.wff.bus.updates;

import com.flat.tools.buses.databus.components.Update;
import com.flat.view.main.panes.center.children.practice.base.Practice;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PracticePaneUpdate extends Update {
    private Practice practicePane;

    public PracticePaneUpdate (Practice _practicePane) {
        super(Type.PRACTICE_PANE_UPDATE);
        this.practicePane = _practicePane;
    }

    // Getters for object's attributes.
    public Practice getPracticePane() {
        return practicePane;
    }

    // Setters for object's attributes.
    public void setPracticePane(Practice practicePane) {
        this.practicePane = practicePane;
    }

}