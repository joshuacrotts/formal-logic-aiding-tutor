package com.flat.view.settings.scene;

import com.flat.view.settings.scene.pane.SettingsPane;
import javafx.scene.Scene;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class SettingsScene extends Scene {

    public SettingsScene() {
        super(new SettingsPane());
    }

}