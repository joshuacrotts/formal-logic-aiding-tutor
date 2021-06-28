package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.previewpane.previewborderpane.panes.observer;

import com.flat.models.fx.FxPreviewData;
import com.flat.models.fx.observables.color.extend.ObservableBorderColor;
import com.flat.models.fx.observables.color.extend.ObservablePrimaryColor;
import com.flat.models.fx.observables.color.extend.ObservableSecondaryColor;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public abstract class ColorObserverPane extends Pane implements Observer {
    private final BorderWidths borderWidths;

    public ColorObserverPane(BorderWidths _borderWidths) {
        this.borderWidths = _borderWidths;
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof ObservablePrimaryColor)
            this.setBackground(new Background(new BackgroundFill(FxPreviewData.getPrimaryColor().getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        else if (obs instanceof ObservableSecondaryColor)
            this.setBackground(new Background(new BackgroundFill(FxPreviewData.getSecondaryColor().getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        else if (obs instanceof ObservableBorderColor)
            this.setBorder(new Border(new BorderStroke(FxPreviewData.getBorderColor().getColor(), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, this.borderWidths)));
    }

}