package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtree.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportPdfTruthTree extends Event {

    public ExportPdfTruthTree () {
        super(Event.Type.EXPORT_PDF_TRUTH_TREE);
    }

}