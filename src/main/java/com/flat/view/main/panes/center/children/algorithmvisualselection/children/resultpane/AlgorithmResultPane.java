package com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane;

import com.flat.controller.Controller;
import com.flat.view.main.panes.center.children.algorithmvisualselection.children.resultpane.listener.AlgorithmResultListener;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class AlgorithmResultPane extends HBox {
    private Text resultLabel = new Text("Result:");
    private Text result = new Text("");

    public AlgorithmResultPane () {
        this.initializeFx();
        Controller.EVENT_BUS.addListener(new AlgorithmResultListener(this));
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx() {
        super.getChildren().addAll(this.resultLabel, this.result);
        super.setSpacing(5);
    }

    // Getters for object's attributes.
    public Text getResultLabel() {
        return resultLabel;
    }

    public Text getResult() {
        return result;
    }

    // Setters for object's attributes.
    public void setResultLabel(Text resultLabel) {
        this.resultLabel = resultLabel;
    }

    public void setResult(Text result) {
        this.result = result;
    }

}