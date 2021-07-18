package com.flat.view.popups.syntax.warning;

import com.flat.input.FLATErrorListener;
import com.flat.view.popups.baseclass.Popup;
import com.flat.view.popups.syntax.error.pane.SyntaxErrorPane;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxWarningPopup extends Popup {

    public SyntaxWarningPopup (Iterator<FLATErrorListener.Message> _errors) {
        super(new SyntaxErrorPane(_errors));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    }

}