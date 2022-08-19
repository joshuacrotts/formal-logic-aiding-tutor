package com.flat.view.main.panes.top.menupane.context.buttons.export.items.pdf.items.truthtable.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportPdfTruthTable extends Event {

    public ExportPdfTruthTable () {
        super(Type.EXPORT_PDF_TRUTH_TABLE);
    }

}