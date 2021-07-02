package com.flat.view.viewdata.pane.panes;

import com.flat.view.viewdata.pane.fxextension.PanePropertyExtension;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BottomPaneProperties extends PanePropertyExtension {

    public BottomPaneProperties () {
        super.getBackgroundProperties().setColor(Color.GRAY);
    }

}