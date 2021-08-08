package com.flat.tools.exporter.listener;

import com.flat.input.events.SolvedFormula;
import com.flat.tools.buses.eventbus.components.Event;
import com.flat.tools.buses.eventbus.components.EventListener;
import com.flat.tools.exporter.ViewExporter;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ViewExporterListener implements EventListener {
    private ViewExporter exporter;

    public ViewExporterListener (ViewExporter _exporter) {
        this.exporter = _exporter;
    }

    @Override
    public void catchEvent(Event _event) {
        switch (_event.getType()) {
            case EXPORT_PDF_TRUTH_TREE:
                this.exporter.exportPdfTruthTree();
                break;
            case EXPORT_PDF_TRUTH_TABLE:
                this.exporter.exportPdfTruthTable();
                break;
            case EXPORT_PDF_PARSE_TREE:
                this.exporter.exportPdfParseTree();
                break;
            case EXPORT_LATEX_TRUTH_TREE:
                this.exporter.exportLatexTruthTree();
                break;
            case EXPORT_LATEX_TRUTH_TABLE:
                this.exporter.exportLatexTruthTable();
                break;
            case EXPORT_LATEX_PARSE_TREE:
                this.exporter.exportLatexParseTree();
                break;
        }
    }

}