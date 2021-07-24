package com.flat.view.popups.base;

import com.flat.view.popups.base.buttons.CloseButton;
import com.flat.view.popups.base.buttons.IconButton;
import com.flat.view.popups.base.buttons.PopupOkButton;
import com.flat.view.data.fx.pane.PaneData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PopupPane extends VBox {
    private HBox headerBox = new HBox();
    private Text messageHeader = new Text();
    private Region headerEmptyRegion = new Region();
    private CloseButton closeButton = new CloseButton();
    private HBox messageHBox = new HBox();
    private IconButton icon = new IconButton();
    private VBox messageVBox = new VBox();
    private Text message = new Text();
    private PopupOkButton okButton = new PopupOkButton();

    public PopupPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
        this.setHeaderBoxFx();
        this.setMessageHeaderFx();
        this.setMessageHBoxFx();
        this.setHeaderEmptyRegionFx();
        this.setCloseButtonFx();
        this.setIconFx();
        this.setMessageVBoxFx();
        this.setMessageFx();
        this.setButtonFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.headerBox, this.messageHBox);
        super.setAlignment(Pos.CENTER);
        super.backgroundProperty().bind(PaneData.getTopProperty().backgroundProperty());
    }

    private void setHeaderBoxFx () {
        this.headerBox.getChildren().addAll(this.messageHeader, this.headerEmptyRegion, this.closeButton);
        VBox.setMargin(this.headerBox, new Insets(5, 5, 5, 5));
        this.headerBox.setAlignment(Pos.CENTER_LEFT);
        this.headerBox.backgroundProperty().bind(PaneData.getLeftProperty().backgroundProperty());
    }

    private void setMessageHeaderFx () {
        HBox.setMargin(this.messageHeader, new Insets(5));
    }

    private void setHeaderEmptyRegionFx () {
        HBox.setHgrow(this.headerEmptyRegion, Priority.ALWAYS);
    }

    private void setCloseButtonFx () {
        HBox.setMargin(this.closeButton, new Insets(5));
    }

    private void setMessageHBoxFx () {
        this.messageHBox.getChildren().addAll(this.icon, this.messageVBox);
        this.messageHBox.setStyle("-fx-background-color: whitesmoke");
        VBox.setMargin(this.messageHBox, new Insets(0, 5, 10, 5));
        VBox.setVgrow(this.messageHBox, Priority.ALWAYS);
        this.messageHBox.setAlignment(Pos.CENTER);
    }

    private void setIconFx () {
        HBox.setMargin(this.icon, new Insets(10));
        this.icon.setStyle("-fx-background-color: whitesmoke");
    }

    private void setMessageVBoxFx () {
        this.messageVBox.getChildren().addAll(this.message, this.okButton);
        HBox.setHgrow(this.messageVBox, Priority.ALWAYS);
        this.messageVBox.setAlignment(Pos.CENTER);

    }

    private void setMessageFx () {
        VBox.setMargin(this.message, new Insets(10));
    }

    private void setButtonFx () {
        VBox.setMargin(this.okButton, new Insets(5, 10, 10, 10));
    }

    // Getters for object's attributes.
    public HBox getHeaderBox() {
        return headerBox;
    }

    public Text getMessageHeader() {
        return messageHeader;
    }

    public Region getHeaderEmptyRegion() {
        return headerEmptyRegion;
    }

    public CloseButton getCloseButton() {
        return closeButton;
    }

    public HBox getMessageHBox() {
        return messageHBox;
    }

    public IconButton getIcon() {
        return icon;
    }

    public VBox getMessageVBox() {
        return messageVBox;
    }

    public Text getMessage() {
        return message;
    }

    public PopupOkButton getOkButton() {
        return okButton;
    }

    // Setters for object's attributes.
    public void setHeaderBox(HBox headerBox) {
        this.headerBox = headerBox;
    }

    public void setMessageHeader(Text messageHeader) {
        this.messageHeader = messageHeader;
    }

    public void setHeaderEmptyRegion(Region headerEmptyRegion) {
        this.headerEmptyRegion = headerEmptyRegion;
    }

    public void setCloseButton(CloseButton closeButton) {
        this.closeButton = closeButton;
    }

    public void setMessageHBox(HBox messageHBox) {
        this.messageHBox = messageHBox;
    }

    public void setIcon(IconButton icon) {
        this.icon = icon;
    }

    public void setMessageVBox(VBox messageVBox) {
        this.messageVBox = messageVBox;
    }

    public void setMessage(Text message) {
        this.message = message;
    }

    public void setOkButton(PopupOkButton okButton) {
        this.okButton = okButton;
    }

}