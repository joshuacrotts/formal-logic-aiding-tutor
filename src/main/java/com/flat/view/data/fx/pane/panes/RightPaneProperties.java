package com.flat.view.data.fx.pane.panes;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RightPaneProperties extends PanePropertyExtension {

    public RightPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
    }

}