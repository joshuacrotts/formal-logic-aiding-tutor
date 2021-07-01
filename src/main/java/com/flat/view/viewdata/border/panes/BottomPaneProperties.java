package com.flat.view.viewdata.border.panes;

import com.flat.view.viewdata.border.BorderData;
import com.flat.view.viewdata.border.panes.fxextension.FxPropertyExtension;
import com.flat.view.viewdata.border.panes.fxextension.properties.BackgroundProperties;
import com.flat.view.viewdata.border.panes.fxextension.properties.BorderProperties;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BottomPaneProperties extends FxPropertyExtension {

    public BottomPaneProperties () {
        super(new BorderProperties(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(BorderData.WIDTH, 0, 0, 0)),
                new BackgroundProperties(Color.GRAY, CornerRadii.EMPTY, new Insets(0)));
    }

}