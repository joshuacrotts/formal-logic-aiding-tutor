package com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential;

import com.flat.controller.Controller;
import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.LogicSymbol;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.LogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.contextmenu.LogicContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.base.tooltip.LogicTooltip;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.contextmenu.ExistentialContextMenu;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.tooltip.ExistentialTooltip;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExistentialLogicButton extends LogicButton {

    public ExistentialLogicButton(KeyedText _general, LogicTooltip _tooltip, LogicContextMenu _logicContextMenu) {
        super(
                Controller.MAPPED_TEXT.getValue(ExistentialSymbol.class, LogicSymbol.Keys.GENERAL),
                new ExistentialTooltip(),
                new ExistentialContextMenu()
        );
    }

}