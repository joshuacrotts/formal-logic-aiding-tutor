package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.parsetree.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportPdfParseTree extends Event {

    public ExportPdfParseTree () {
        super(Event.Type.EXPORT_PDF_PARSE_TREE);
    }

}