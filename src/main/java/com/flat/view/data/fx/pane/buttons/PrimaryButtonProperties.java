package com.flat.view.data.fx.pane.buttons;

import com.flat.view.data.fx.pane.panes.fxextension.PanePropertyExtension;
import com.flat.view.data.fx.settings.appearance.AppearancePreviewData;
import javafx.scene.layout.CornerRadii;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PrimaryButtonProperties extends PanePropertyExtension {

    public PrimaryButtonProperties () {
        super.getBackgroundProperties().setColor(AppearancePreviewData.getSecondaryColor().getColor());
        super.getBackgroundProperties().setCornerRadii(new CornerRadii(10));
    }

}