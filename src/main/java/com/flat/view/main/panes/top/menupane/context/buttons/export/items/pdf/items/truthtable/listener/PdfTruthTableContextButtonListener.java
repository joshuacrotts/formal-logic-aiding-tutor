package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable.listener;

import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.CLEAR_LOGIC_VISUALS;
import static com.flat.tools.buses.eventbus.components.Event.Type.UPDATE_TRUTH_TABLE;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable.PdfTruthTableContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTableContextButtonListener implements EventListener {
    private PdfTruthTableContextButton button;

    public PdfTruthTableContextButtonListener (PdfTruthTableContextButton _button) {
        this.button = _button;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.button.setDisable(true);
                break;
            case UPDATE_TRUTH_TABLE:
                this.button.setDisable(false);
                break;
        }
    }

}