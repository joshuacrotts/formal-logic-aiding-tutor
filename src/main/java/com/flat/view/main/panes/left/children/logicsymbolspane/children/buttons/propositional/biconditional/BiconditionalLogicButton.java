package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional;

import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.propositional.biconditional.attributes.BiconditionalSymbols;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.contextmenu.BiconditionalContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.tooltip.BiconditionalTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BiconditionalLogicButton extends LogicButton {

    public BiconditionalLogicButton () {
        super(
                Controller.MAPPED_TEXT.getValue(BiconditionalSymbols.class, LogicSymbol.Keys.GENERAL),
                new BiconditionalTooltip(),
                new BiconditionalContextMenu()
        );
    }

}