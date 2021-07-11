package com.flat.view.viewdata.pane.panes;

import com.flat.view.viewdata.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.viewdata.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TopPaneProperties extends PanePropertyExtension {

    public TopPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getPrimaryColor().getColor());
    }

}