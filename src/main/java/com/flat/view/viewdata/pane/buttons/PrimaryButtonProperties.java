package com.flat.view.viewdata.pane.buttons;

import com.flat.view.viewdata.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.viewdata.settings.AppearancePreviewData;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryButtonProperties extends PanePropertyExtension {

    public PrimaryButtonProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
    }

}