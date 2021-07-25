package com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane;

import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.bordercolorpane.BorderColorPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.primarycolorpane.PrimaryColorPane;
import com.flat.view.settings.scene.pane.children.selection.apperance.appearancepane.previewpane.colorpane.secondarycolorpane.SecondaryColorPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ColorPane extends VBox {
    private final PrimaryColorPane primaryColorPane = new PrimaryColorPane();
    private final SecondaryColorPane secondaryColorPane = new SecondaryColorPane();
    private final BorderColorPane borderColorPane = new BorderColorPane();

    public ColorPane() {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setPrimaryColorPaneFx();
        this.setSecondaryColorPaneFx();
        this.setBorderColorPaneFx();
    }

    private void setThisFx () {
        super.setMaxHeight(100);
        super.getChildren().addAll(this.primaryColorPane, this.secondaryColorPane, this.borderColorPane);
        super.setAlignment(Pos.CENTER);
        super.getStyleClass().add("colorPane");
    }

    private void setPrimaryColorPaneFx () {
        VBox.setMargin(this.primaryColorPane, new Insets(10));
    }

    private void setSecondaryColorPaneFx () {
        VBox.setMargin(this.secondaryColorPane, new Insets(10));
    }

    private void setBorderColorPaneFx () {
        VBox.setMargin(this.borderColorPane, new Insets(10));
    }

}