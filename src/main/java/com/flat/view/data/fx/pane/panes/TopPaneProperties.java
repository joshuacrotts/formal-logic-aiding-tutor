package com.flat.view.data.fx.pane.panes;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TopPaneProperties extends PanePropertyExtension {

    public TopPaneProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getPrimaryColor().getColor());
    }

}