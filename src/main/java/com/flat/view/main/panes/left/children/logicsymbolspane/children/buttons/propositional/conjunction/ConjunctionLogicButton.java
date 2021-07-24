package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.biconditional.attributes.BiconditionalSymbols;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.contextmenu.menuitems.ConjunctionContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.tooltip.ConjunctionTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ConjunctionLogicButton extends LogicButton {

    public ConjunctionLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(BiconditionalSymbols.class, LogicSymbol.Keys.GENERAL),
                new ConjunctionTooltip(),
                new ConjunctionContextMenu()
        );
    }

}