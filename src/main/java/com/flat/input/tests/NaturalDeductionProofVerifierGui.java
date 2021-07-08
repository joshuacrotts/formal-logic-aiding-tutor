package com.flat.input.tests;

import com.flat.algorithms.NaturalDeductionProofVerifier;
import com.flat.algorithms.models.NDStep;
import com.flat.input.FLATParserAdapter;
import com.flat.models.treenode.WffTree;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NaturalDeductionProofVerifierGui extends Application {

    private BorderPane rootPane;

    private NaturalDeductionProofVerifier naturalDeductionProofVerifier;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        rootPane = new BorderPane();
        HBox hbox = addInitialHBox();
        rootPane.setBottom(hbox);

        primaryStage.setScene(new Scene(rootPane, 300, 250));
        primaryStage.show();
    }

    public HBox addInitialHBox() {
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #336699;");
        TextField initArgumentField = new TextField("Enter initial argument here.");
        Button buttonCurrent = new Button("Submit");
        buttonCurrent.setPrefSize(100, 20);
        buttonCurrent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent _event) {
                naturalDeductionProofVerifier = new NaturalDeductionProofVerifier(FLATParserAdapter.getAbstractSyntaxTree(initArgumentField.getText()));
                rootPane.getChildren().remove(hbox);
                rootPane.setBottom(addInputBoxes());
            }
        });
        hbox.getChildren().addAll(initArgumentField, buttonCurrent);
        return hbox;
    }

    private HBox addInputBoxes() {
        TextArea argument = new TextArea();
        argument.setEditable(false);
        rootPane.setCenter(argument);
        this.displayArgument(argument);
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #336699;");
        TextField initArgumentField = new TextField("Enter wff.");
        ComboBox<NDStep> steps = new ComboBox<>();
        TextField parents = new TextField("Enter parents (1, 2, ...)");
        steps.getItems().addAll(NDStep.values());
        Button buttonCurrent = new Button("Submit");
        buttonCurrent.setPrefSize(100, 20);
        buttonCurrent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent _event) {
                WffTree tree = FLATParserAdapter.getAbstractSyntaxTree(initArgumentField.getText()).get(0);
                NDStep step = steps.getValue();
                String p = parents.getText();
                System.out.println("Tree: " + tree.getStringRep() + ", step: " + step.toString() + ", p: " + p);
                if (naturalDeductionProofVerifier.proveNaturalDeduction(tree, step, p)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Congratulations, the proof is complete!");
                    alert.showAndWait();
                };
                displayArgument(argument);
            }
        });
        hbox.getChildren().addAll(initArgumentField, steps, parents, buttonCurrent);
        return hbox;
    }

    private void displayArgument(TextArea _textArea) {
        _textArea.setText("");
        for (int i = 0; i < naturalDeductionProofVerifier.getPremisesList().size(); i++) {
            _textArea.appendText((i + 1) + ": " + naturalDeductionProofVerifier.getPremisesList().get(i).toString());
            _textArea.appendText("\n");
        }
        _textArea.appendText("Prove: " + naturalDeductionProofVerifier.getConclusionWff().getWffTree().getStringRep());
    }
}
