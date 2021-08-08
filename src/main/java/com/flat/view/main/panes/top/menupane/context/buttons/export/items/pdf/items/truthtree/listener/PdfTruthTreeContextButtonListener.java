package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree.listener;

import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.CLEAR_LOGIC_VISUALS;
import static com.flat.tools.buses.eventbus.components.Event.Type.UPDATE_TRUTH_TREE;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree.PdfTruthTreeContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PdfTruthTreeContextButtonListener implements EventListener {
    private PdfTruthTreeContextButton button;

    public PdfTruthTreeContextButtonListener (PdfTruthTreeContextButton _button) {
        this.button = _button;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case CLEAR_LOGIC_VISUALS:
                this.button.setDisable(true);
                break;
            case UPDATE_TRUTH_TREE:
                this.button.setDisable(false);
                break;
        }
    }

}