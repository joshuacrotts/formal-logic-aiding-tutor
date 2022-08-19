package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtable.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportLatexTruthTable extends Event {

    public ExportLatexTruthTable () {
        super(Type.EXPORT_LATEX_TRUTH_TABLE);
    }

}