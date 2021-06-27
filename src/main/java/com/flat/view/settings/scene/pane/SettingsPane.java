package com.flat.view.settings.scene.pane;

import com.flat.view.settings.scene.pane.children.buttonbar.SettingsButtonBar;
import com.flat.view.settings.scene.pane.children.tabpane.SettingsTabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class SettingsPane extends VBox {
    private SettingsTabPane settingsTabPane = new SettingsTabPane();
    private SettingsButtonBar settingsButtonBar = new SettingsButtonBar();

    public SettingsPane () {
        super.getChildren().addAll(this.settingsTabPane, this.settingsButtonBar);
        this.setSettingsTabPaneFx();
    }

    public void setSettingsTabPaneFx() {
        VBox.setVgrow(this.settingsTabPane, Priority.ALWAYS);
    }

}