package com.flat.view.main.panes.center.children.practice.base.bus.updates;

import com.flat.tools.buses.databus.components.Update;
import com.flat.view.main.panes.center.children.practice.base.AlgorithmPracticePane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmPracticePaneUpdate extends Update {
    private AlgorithmPracticePane practicePane;

    public AlgorithmPracticePaneUpdate (AlgorithmPracticePane _practicePane) {
        super(Update.Type.ALGORITHM_PRACTICE_PANE);
        this.practicePane = _practicePane;
    }

    // Getters for object's attributes.
    public AlgorithmPracticePane getPracticePane() {
        return practicePane;
    }

    // Setters for object's attributes.
    public void setPracticePane(AlgorithmPracticePane practicePane) {
        this.practicePane = practicePane;
    }

}