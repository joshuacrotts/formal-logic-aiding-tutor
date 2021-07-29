package com.flat.view.popups.naturaldeduction;

import com.flat.view.popups.base.Popup;
import com.flat.view.popups.naturaldeduction.pane.NaturalDeductionPopupPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPopup extends Popup {

    public NaturalDeductionPopup () {
        super(new NaturalDeductionPopupPane());
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    }

}