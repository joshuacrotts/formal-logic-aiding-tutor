package com.flat.view.popups.syntax.error;

import com.flat.input.FLATErrorListener.Message;
import com.flat.view.popups.base.Popup;
import com.flat.view.popups.syntax.error.pane.SyntaxErrorPane;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxErrorPopup extends Popup {

    public SyntaxErrorPopup (Iterator<Message> _errors) {
        super(new SyntaxErrorPane(_errors));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
    }

}