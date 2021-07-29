package com.flat.view.popups.naturaldeduction.pane;

import com.flat.view.popups.base.PopupPane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class NaturalDeductionPopupPane extends PopupPane {

    public NaturalDeductionPopupPane () {
        super.getMessageHeader().setText("Natural Deduction");
        super.getMessage().setText("Either the argument is invalid (check the above result) or it timed out!");
    }

}