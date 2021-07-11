package com.flat.view.main.panes.top.menupane;

import com.flat.view.main.panes.top.menupane.context.base.ContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.export.ExportMenuButton;
import com.flat.view.main.panes.top.menupane.context.buttons.file.FileContextButton;
import com.flat.view.main.panes.top.menupane.context.buttons.help.HelpContextButton;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
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
        this.setParentProperty();
    }

    private void setButtonHoverProperty (ContextButton _contextButton, ContextButton... _contextButtons) {
        _contextButton.hoverProperty().addListener(event -> {
            if (_contextButton.isHover()) {
                for (ContextButton context : _contextButtons)
                    context.setToggle(false);
            }
        });
    }

    private void setParentProperty () {
        super.parentProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null)
                this.closeMenus();
            else
                this.onMouseExitParent(newVal);
        });
    }

    private void onMouseExitParent (Node _node) {
        _node.setOnMouseExited(event -> {
            if (event.getSceneY() <= this.getBoundsInParent().getMinY())
                this.closeMenus();
        });
    }

    public void closeMenus () {
        this.fileButton.closeMenus();
        this.helpButton.closeMenus();
        this.exportButton.closeMenus();
    }

}