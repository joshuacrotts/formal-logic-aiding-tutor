package com.flat.view.viewdata.border;

import com.flat.view.viewdata.border.panes.BottomBorderProperty;
import com.flat.view.viewdata.border.panes.LeftBorderProperty;
import com.flat.view.viewdata.border.panes.RightBorderProperty;
import com.flat.view.viewdata.border.panes.TopBorderProperty;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class BorderData {
    private final static TopBorderProperty topProperty = new TopBorderProperty();
    private final static RightBorderProperty rightProperty = new RightBorderProperty();
    private final static BottomBorderProperty bottomProperty = new BottomBorderProperty();
    private final static LeftBorderProperty leftProperty = new LeftBorderProperty();

    // Getters for object's attributes.
    public static TopBorderProperty getTopProperty() {
        return topProperty;
    }

    public static RightBorderProperty getRightProperty() {
        return rightProperty;
    }

    public static BottomBorderProperty getBottomProperty() {
        return bottomProperty;
    }

    public static LeftBorderProperty getLeftProperty() {
        return leftProperty;
    }

}