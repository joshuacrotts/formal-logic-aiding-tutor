package com.flat.view.data.fx.pane.panes;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class BorderPaneProperties extends PanePropertyExtension {

    public BorderPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getBorderColor().getColor());
    }

}