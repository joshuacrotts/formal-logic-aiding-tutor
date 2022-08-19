package com.flat.view.popups.proofverifier.error;

import com.flat.input.FLATErrorListener.Message;
import com.flat.view.popups.base.Popup;
import com.flat.view.popups.proofverifier.error.pane.ProofVerifierErrorPane;

import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ProofVerifierErrorPopup extends Popup {

    public ProofVerifierErrorPopup (Iterator <Message> _errors) {
        super(new ProofVerifierErrorPane(_errors));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    }

}