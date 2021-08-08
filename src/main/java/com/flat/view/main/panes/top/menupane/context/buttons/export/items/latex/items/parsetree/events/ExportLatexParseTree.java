package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.parsetree.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportLatexParseTree extends Event {

    public ExportLatexParseTree () {
        super(Event.Type.EXPORT_LATEX_PARSE_TREE);
    }

}