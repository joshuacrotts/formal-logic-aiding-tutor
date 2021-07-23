package com.flat.view.data.fx.algorithms.listener;

import com.flat.models.algorithms.bus.updates.ApplicableAlgorithmsUpdate;
import com.flat.tools.buses.databus.components.DataListener;
import com.flat.tools.buses.databus.components.Update;
import com.flat.view.data.fx.algorithms.AvailableAlgorithms;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AvailableAlgorithmsListener implements DataListener {
    private AvailableAlgorithms algorithms;

    public AvailableAlgorithmsListener (AvailableAlgorithms _algorithms) {
        this.algorithms = _algorithms;
    }

    @Override
    public void handleUpdate(Update _update) {
        switch (_update.getType()) {
            case APPLICABLE_ALGORITHMS:
                this.algorithms.clearAlgorithms();
                this.algorithms.addGeneralAlgorithms(((ApplicableAlgorithmsUpdate)_update).getAlgorithms().getGeneral());
                this.algorithms.addPredicateAlgorithms(((ApplicableAlgorithmsUpdate)_update).getAlgorithms().getPredicate());
                this.algorithms.addPropositionalAlgorithms(((ApplicableAlgorithmsUpdate)_update).getAlgorithms().getPropositional());
                break;
        }
    }

}