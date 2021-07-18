package com.flat.view.popups.syntax.warning.pane;

import com.flat.input.FLATErrorListener.Message;
import com.flat.view.popups.baseclass.PopupPane;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxWarningPane extends PopupPane {

    public SyntaxWarningPane (Iterator<Message> _warnings) {
        super.getMessagHeader().setText("Syntax Warning");
        this.setMessages(_warnings);
    }

    private void setMessages (Iterator<Message> _warnings) {
        StringBuilder sb = new StringBuilder();
        sb.append(_warnings.next().toString());
        _warnings.forEachRemaining(message -> {
            sb.append("\n").append(message.toString());
        });
        super.getMessage().setText(sb.toString());
    }

}