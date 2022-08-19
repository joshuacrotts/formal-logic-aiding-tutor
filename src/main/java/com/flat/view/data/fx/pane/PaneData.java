package com.flat.view.data.fx.pane;

import com.flat.view.data.fx.pane.buttons.PrimaryButtonProperties;
import com.flat.view.data.fx.pane.panes.*;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PaneData {
    private final static TopPaneProperties topProperty = new TopPaneProperties();
    private final static RightPaneProperties rightProperty = new RightPaneProperties();
    private final static BottomPaneProperties bottomProperty = new BottomPaneProperties();
    private final static LeftPaneProperties leftProperty = new LeftPaneProperties();
    private final static BorderPaneProperties borderProperty = new BorderPaneProperties();
    private final static PrimaryButtonProperties primaryButtonProperty = new PrimaryButtonProperties();

    // Getters for object's attributes.
    public static TopPaneProperties getTopProperty() {
        return topProperty;
    }

    public static RightPaneProperties getRightProperty() {
        return rightProperty;
    }

    public static BottomPaneProperties getBottomProperty() {
        return bottomProperty;
    }

    public static LeftPaneProperties getLeftProperty() {
        return leftProperty;
    }

    public static BorderPaneProperties getBorderProperty() {
        return borderProperty;
    }

    public static PrimaryButtonProperties getPrimaryButtonProperty() {
        return primaryButtonProperty;
    }

}