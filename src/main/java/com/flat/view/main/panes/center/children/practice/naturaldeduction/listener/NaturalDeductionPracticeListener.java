package com.flat.view.main.panes.center.children.practice.naturaldeduction.listener;

import com.flat.algorithms.NaturalDeductionProofVerifier;
import com.flat.algorithms.models.NDStep;
import com.flat.controller.Controller;
import com.flat.input.events.SolvedFormula;
import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.SOLVED_FORMULA;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.center.children.practice.listener.events.PracticeResult;
import com.flat.view.main.panes.center.children.practice.naturaldeduction.NaturalDeductionPractice;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPracticeListener implements EventListener {
    private NaturalDeductionPractice pane;

    public NaturalDeductionPracticeListener (NaturalDeductionPractice _pane) {
        this.pane = _pane;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case SOLVED_FORMULA:
                if (this.pane.getUserProof() == null)
                    this.pane.userProof = (new NaturalDeductionProofVerifier(this.pane.getProofWff()));
                if (this.pane.getUserProof().proveNaturalDeduction(((SolvedFormula)_event).getWffTree().get(0), ((NDStep)this.pane.getNdInputPane().getStepInput().getSelectionModel().getSelectedItem()), this.pane.getNdInputPane().getLineInput().getText()))
                    Controller.DATA_BUS.throwUpdate(new PracticeResult(true));
                if (!Controller.displayProofVerifierErrorPopup()) {
                    this.pane.addLastPremise();
                    this.pane.getNdInputPane().clearInput();
                }
                else {
                    Controller.DATA_BUS.throwUpdate(new PracticeResult(false));
                }
                break;
        }
    }

}