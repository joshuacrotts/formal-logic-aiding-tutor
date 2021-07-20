package com.flat.view.data.fx.pane.buttons;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryButtonProperties extends PanePropertyExtension {

    public PrimaryButtonProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
    }

}