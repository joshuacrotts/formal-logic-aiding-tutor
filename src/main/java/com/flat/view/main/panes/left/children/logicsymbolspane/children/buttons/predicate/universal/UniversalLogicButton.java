package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal;

import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;
import com.flat.controller.Controller;
import com.flat.models.data.logicsymbols.LogicSymbols;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.contextmenu.UniversalContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.tooltip.UniversalTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class UniversalLogicButton extends LogicButton {

    public UniversalLogicButton () {
        super(
                LogicSymbols.SymbolKey.UNIVERSAL,
                Controller.MAPPED_TEXT.getValue(UniversalSymbol.class, UniversalSymbol.Keys.GENERAL),
                new UniversalTooltip(),
                new UniversalContextMenu()
        );
    }

}