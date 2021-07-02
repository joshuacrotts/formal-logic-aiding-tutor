package com.flat.view.viewdata.pane;

import com.flat.view.viewdata.pane.panes.BorderPaneProperties;
import com.flat.view.viewdata.pane.panes.BottomPaneProperties;
import com.flat.view.viewdata.pane.panes.LeftPaneProperties;
import com.flat.view.viewdata.pane.panes.RightPaneProperties;
import com.flat.view.viewdata.pane.panes.TopPaneProperties;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class PaneData {
    private final static TopPaneProperties topProperty = new TopPaneProperties();
    private final static RightPaneProperties rightProperty = new RightPaneProperties();
    private final static BottomPaneProperties bottomProperty = new BottomPaneProperties();
    private final static LeftPaneProperties leftProperty = new LeftPaneProperties();
    private final static BorderPaneProperties borderProperty = new BorderPaneProperties();

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

}