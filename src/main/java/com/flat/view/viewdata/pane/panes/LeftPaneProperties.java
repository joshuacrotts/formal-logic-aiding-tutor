package com.flat.view.viewdata.pane.panes;

import com.flat.view.viewdata.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.viewdata.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LeftPaneProperties extends PanePropertyExtension {

    public LeftPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
    }

}