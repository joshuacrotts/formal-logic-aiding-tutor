package com.flat.view.viewdata.border;

import com.flat.view.viewdata.border.panes.BottomPaneProperties;
import com.flat.view.viewdata.border.panes.LeftPaneProperties;
import com.flat.view.viewdata.border.panes.RightPaneProperties;
import com.flat.view.viewdata.border.panes.TopPaneProperties;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BorderData {
    public final static int WIDTH = 3;
    private final static TopPaneProperties topProperty = new TopPaneProperties();
    private final static RightPaneProperties rightProperty = new RightPaneProperties();
    private final static BottomPaneProperties bottomProperty = new BottomPaneProperties();
    private final static LeftPaneProperties leftProperty = new LeftPaneProperties();

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

}