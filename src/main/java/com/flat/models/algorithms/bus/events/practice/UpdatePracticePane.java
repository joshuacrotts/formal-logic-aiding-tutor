package com.flat.models.algorithms.bus.events.practice;

import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UpdatePracticePane extends Event {
    private AlgorithmType algorithmType;

    public UpdatePracticePane (AlgorithmType _algorithmType) {
        super(Event.Type.UPDATE_PRACTICE_PANE);
        this.algorithmType = _algorithmType;
    }

    // Getters for object's attributes.
    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    // Setters for object's attributes.
    public void setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

}