package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.contextmenu.menuitems.DisjunctionContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.tooltip.DisjunctionTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class DisjunctionLogicButton extends LogicButton {

    public DisjunctionLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(DisjunctionSymbol.class, LogicSymbol.Keys.GENERAL),
                new DisjunctionTooltip(),
                new DisjunctionContextMenu()
        );
    }

}