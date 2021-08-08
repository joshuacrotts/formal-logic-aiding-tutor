package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.parsetree.listener;

import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.CLEAR_LOGIC_VISUALS;
import static com.flat.tools.buses.eventbus.components.Event.Type.UPDATE_PARSE_TREE;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.parsetree.PdfParseTreeContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfParseTreeContextButtonListener implements EventListener {
    private PdfParseTreeContextButton button;

    public PdfParseTreeContextButtonListener (PdfParseTreeContextButton _button) {
        this.button = _button;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.button.setDisable(true);
                break;
            case UPDATE_PARSE_TREE:
                this.button.setDisable(false);
                break;
        }
    }

}