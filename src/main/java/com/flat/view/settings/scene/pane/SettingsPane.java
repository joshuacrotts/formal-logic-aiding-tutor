package com.flat.view.settings.scene.pane;

import com.flat.view.settings.scene.pane.children.tabpane.SettingsTabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsPane extends VBox {
    private final SettingsTabPane settingsTabPane = new SettingsTabPane();

    public SettingsPane() {
        super.getChildren().addAll(this.settingsTabPane);
        this.setSettingsTabPaneFx();
    }

    private void setSettingsTabPaneFx() {
        VBox.setVgrow(this.settingsTabPane, Priority.ALWAYS);
    }

}