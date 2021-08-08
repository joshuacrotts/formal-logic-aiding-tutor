package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree.listener;

import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree.LatexParseTreeContextButton;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LatexParseTreeContextButtonListener implements EventListener {
    private LatexParseTreeContextButton button;

    public LatexParseTreeContextButtonListener (LatexParseTreeContextButton _button) {
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