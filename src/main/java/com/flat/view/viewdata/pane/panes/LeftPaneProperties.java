package com.flat.view.viewdata.pane.panes;

import com.flat.view.viewdata.pane.fxextension.PanePropertyExtension;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class LeftPaneProperties extends PanePropertyExtension {

    public LeftPaneProperties () {
        super.getBackgroundProperties().setColor(Color.LIGHTGRAY);
    }

}