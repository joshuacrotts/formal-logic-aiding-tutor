package com.flat.view.viewdata.pane.panes;

import com.flat.view.viewdata.pane.fxextension.PanePropertyExtension;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class RightPaneProperties extends PanePropertyExtension {

    public RightPaneProperties () {
        super.getBackgroundProperties().setColor(Color.LIGHTGRAY);
    }

}