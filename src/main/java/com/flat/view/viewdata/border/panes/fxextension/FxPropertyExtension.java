package com.flat.view.viewdata.border.panes.fxextension;

import com.flat.view.viewdata.border.panes.fxextension.properties.BackgroundProperties;
import com.flat.view.viewdata.border.panes.fxextension.properties.BorderProperties;
import javafx.scene.layout.Pane;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FxPropertyExtension extends Pane {
    private BorderProperties borderProperties;
    private BackgroundProperties backgroundProperties;

    public FxPropertyExtension (BackgroundProperties _backgroundProperties) {
        this.borderProperties = null;
        this.backgroundProperties = _backgroundProperties;
    }

    public FxPropertyExtension (BorderProperties _borderProperties, BackgroundProperties _backgroundProperties) {
        this.borderProperties = _borderProperties;
        this.borderProperties.setPane(this);
        this.backgroundProperties = _backgroundProperties;
        this.backgroundProperties.setPane(this);
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