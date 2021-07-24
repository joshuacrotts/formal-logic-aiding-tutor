package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.contextmenu.ImplicationContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.tooltip.ImplicationTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ImplicationLogicButton extends LogicButton {

    public ImplicationLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(ImplicationSymbol.class, LogicSymbol.Keys.GENERAL),
                new ImplicationTooltip(),
                new ImplicationContextMenu()
        );
    }

}