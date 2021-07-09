package com.flat.view.main.menupane;

import com.flat.view.main.menupane.context.base.ContextButton;
import com.flat.view.main.menupane.context.buttons.export.ExportMenuButton;
import com.flat.view.main.menupane.context.buttons.file.FileContextButton;
import com.flat.view.main.menupane.context.buttons.help.HelpContextButton;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FlatMenuPane extends HBox {
    private FileContextButton fileButton = new FileContextButton();
    private HelpContextButton helpButton = new HelpContextButton();
    private ExportMenuButton exportButton = new ExportMenuButton();

    public FlatMenuPane () {
        super.getChildren().addAll(this.fileButton, this.exportButton, this.helpButton);
        super.setPrefWidth(super.getChildren().size() * ContextButton.getMENU_WIDTH());
        this.setButtonHoverProperty(this.fileButton, this.helpButton, this.exportButton);
        this.setButtonHoverProperty(this.helpButton, this.fileButton, this.exportButton);
        this.setButtonHoverProperty(this.exportButton, this.fileButton, this.helpButton);
    }

    private void setButtonHoverProperty (ContextButton _contextButton, ContextButton... _contextButtons) {
        _contextButton.hoverProperty().addListener(event -> {
            if (_contextButton.isHover()) {
                for (ContextButton context : _contextButtons)
                    context.setToggle(false);
            }
        });
    }

    public void closeMenus () {
        this.fileButton.closeMenus();
        this.helpButton.closeMenus();
        this.exportButton.closeMenus();
    }

}