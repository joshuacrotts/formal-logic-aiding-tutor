package com.flat.view.data.pane.panes;

import com.flat.view.data.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LeftPaneProperties extends PanePropertyExtension {

    public LeftPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
    }

}