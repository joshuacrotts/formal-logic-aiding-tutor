package com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane;

import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.bordercolorpane.BorderColorPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.primarycolorpane.PrimaryColorPane;
import com.flat.view.settings.scene.pane.children.tabpane.tabs.appearancetab.appearancepane.colorpane.secondarycolorpane.SecondaryColorPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class ColorPane extends VBox {
    private final PrimaryColorPane primaryColorPane = new PrimaryColorPane();
    private final SecondaryColorPane secondaryColorPane = new SecondaryColorPane();
    private final BorderColorPane borderColorPane = new BorderColorPane();

    public ColorPane() {
        super.getChildren().addAll(this.primaryColorPane, this.secondaryColorPane, this.borderColorPane);
        super.setAlignment(Pos.CENTER);
    }

}