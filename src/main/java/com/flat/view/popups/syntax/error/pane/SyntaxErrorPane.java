package com.flat.view.popups.syntax.error.pane;

import com.flat.input.FLATErrorListener.Message;
import com.flat.view.popups.base.PopupPane;
import java.util.Iterator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SyntaxErrorPane extends PopupPane {

    public SyntaxErrorPane (Iterator<Message> _errors) {
        super.getMessageHeader().setText("Syntax Error");
        this.setMessages(_errors);
    }

    private void setMessages (Iterator<Message> _errors) {
        if (_errors.hasNext()) {
            StringBuilder sb = new StringBuilder("");
            sb.append(_errors.next().toString());
            _errors.forEachRemaining(message -> {
                sb.append("\n").append(message.toString());
            });
            super.getMessage().setText(sb.toString());
        }
    }

}