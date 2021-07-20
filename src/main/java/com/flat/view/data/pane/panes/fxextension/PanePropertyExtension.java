package com.flat.view.data.pane.panes.fxextension;

import com.flat.view.data.pane.panes.fxextension.properties.BackgroundProperties;
import com.flat.view.data.pane.panes.fxextension.properties.BorderProperties;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PanePropertyExtension extends Pane {
    private BorderProperties borderProperties;
    private BackgroundProperties backgroundProperties;

    public PanePropertyExtension () {
        this.borderProperties = new BorderProperties(this);
        this.backgroundProperties = new BackgroundProperties(this);
    }

    public PanePropertyExtension (BorderProperties _borderProperties, BackgroundProperties _backgroundProperties) {
        this.borderProperties = _borderProperties;
        this.backgroundProperties = _backgroundProperties;
    }

    // Getters for object's attributes.
    public BorderProperties getBorderProperties() {
        return borderProperties;
    }

    public BackgroundProperties getBackgroundProperties() {
        return backgroundProperties;
    }

    // Setters for object's attributes.
    public void setBorderProperties(BorderProperties borderProperties) {
        this.borderProperties = borderProperties;
    }

    public void setBackgroundProperties(BackgroundProperties backgroundProperties) {
        this.backgroundProperties = backgroundProperties;
    }

}