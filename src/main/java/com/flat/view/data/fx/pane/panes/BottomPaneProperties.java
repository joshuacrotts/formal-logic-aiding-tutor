package com.flat.view.data.fx.pane.panes;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BottomPaneProperties extends PanePropertyExtension {

    public BottomPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getPrimaryColor().getColor());
    }

}