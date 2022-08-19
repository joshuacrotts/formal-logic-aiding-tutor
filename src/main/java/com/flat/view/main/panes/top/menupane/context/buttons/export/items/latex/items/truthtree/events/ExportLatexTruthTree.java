package com.flat.view.main.panes.top.menupane.context.buttons.export.items.latex.items.truthtree.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ExportLatexTruthTree extends Event {

    public ExportLatexTruthTree () {
        super(Type.EXPORT_LATEX_TRUTH_TREE);
    }

}