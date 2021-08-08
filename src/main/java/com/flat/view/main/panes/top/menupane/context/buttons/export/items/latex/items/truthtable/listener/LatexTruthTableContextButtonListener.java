package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable.listener;

import com.flat.tools.buses.eventbus.components.Event;
import static com.flat.tools.buses.eventbus.components.Event.Type.CLEAR_LOGIC_VISUALS;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable.LatexTruthTableContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexTruthTableContextButtonListener implements EventListener {
    private LatexTruthTableContextButton button;

    public LatexTruthTableContextButtonListener (LatexTruthTableContextButton _button) {
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