package com.flat.view.popups.baseclass;

import com.flat.view.popups.baseclass.buttons.PopupOkButton;
import com.flat.view.viewdata.pane.PaneData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PopupPane extends VBox {
    private HBox headerBox = new HBox();
    private Text messagHeader = new Text();
    private VBox messageBox = new VBox();
    private Text message = new Text();
    private PopupOkButton okButton = new PopupOkButton();

    public PopupPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setHeaderBoxFx();
        this.setMessageBoxFx();
        this.setButtonFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.headerBox, this.messageBox, this.okButton);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(10);
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

    private void setHeaderBoxFx () {
        this.headerBox.getChildren().add(this.messagHeader);
        VBox.setMargin(this.headerBox, new Insets(10));
        this.headerBox.setAlignment(Pos.CENTER_LEFT);
        this.headerBox.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
    }

    private void setMessageBoxFx () {
        this.messageBox.getChildren().add(this.message);
        VBox.setMargin(this.messageBox, new Insets(10, 20, 10, 20));
        this.messageBox.setAlignment(Pos.CENTER);
        this.messageBox.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
    }

    private void setButtonFx () {
        VBox.setMargin(this.okButton, new Insets(10));
    }

    // Getters for object's attributes.
    public HBox getHeaderBox() {
        return headerBox;
    }

    public Text getMessagHeader() {
        return messagHeader;
    }

    public VBox getMessageBox() {
        return messageBox;
    }

    public Text getMessage() {
        return message;
    }

    public PopupOkButton getButton() {
        return okButton;
    }

    // Setters for object's attributes.
    public void setHeaderBox(HBox headerBox) {
        this.headerBox = headerBox;
    }

    public void setMessagHeader(Text messagHeader) {
        this.messagHeader = messagHeader;
    }

    public void setMessageBox(VBox messageBox) {
        this.messageBox = messageBox;
    }

    public void setMessage(Text message) {
        this.message = message;
    }

    public void setButton(PopupOkButton button) {
        this.okButton = button;
    }

}