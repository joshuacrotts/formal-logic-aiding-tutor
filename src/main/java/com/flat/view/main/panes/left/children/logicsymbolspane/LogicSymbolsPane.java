package com.flat.view.main.panes.left.children.logicsymbolspane;

import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.existential.ExistentialLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.predicate.universal.UniversalLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.biconditional.BiconditionalLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.conjunction.ConjunctionLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.disjunction.DisjunctionLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.doubleturnstile.DoubleTurnstileLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.exclusivedisjunction.ExclusiveDisjunctionLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.implication.ImplicationLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.negation.NegationLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.buttons.propositional.turnstile.TurnstileLogicButton;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.labels.PredicateLabel;
import com.flat.view.main.panes.left.children.logicsymbolspane.children.labels.PropositionalLabel;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbolsPane extends GridPane {
    private final int MAX_WIDTH = 4;
    private final int CUR_ROW = 0;
    private final int CUR_COL = 0;
    // Propositional.
    private PropositionalLabel propositional = new PropositionalLabel();
    private BiconditionalLogicButton biconditional = new BiconditionalLogicButton();
    private ConjunctionLogicButton conjunction = new ConjunctionLogicButton();
    private DisjunctionLogicButton disjunction = new DisjunctionLogicButton();
    private DoubleTurnstileLogicButton doubleTurnstile = new DoubleTurnstileLogicButton();
    private ExclusiveDisjunctionLogicButton exclusiveDisjunction = new ExclusiveDisjunctionLogicButton();
    private ImplicationLogicButton implication = new ImplicationLogicButton();
    private NegationLogicButton negation = new NegationLogicButton();
    private TurnstileLogicButton turnstile = new TurnstileLogicButton();
    // Predicate.
    private PredicateLabel predicate = new PredicateLabel();
    private ExistentialLogicButton existential = new ExistentialLogicButton();
    private UniversalLogicButton universal = new UniversalLogicButton();

    public LogicSymbolsPane () {
        this.initializeFx();
    }

    private void initializeFx () {
        this.setThisFx();
    }

    private void setThisFx () {
        super.getChildren().addAll(this.propositional, this.biconditional, this.conjunction,
                this.disjunction, this.doubleTurnstile, this.exclusiveDisjunction,
                this.implication, this.negation, this.turnstile,
                this.predicate, this.existential, this.universal
        );
        super.setVgap(10);
        super.setHgap(10);
        this.setPropositionalFx();
        this.setBiconditionalFx();
        this.setConjunctionFx();
        this.setDisjunctionFx();
        this.setDoubleTurnstileFx();
        this.setExclusiveDisjunctionFx();
        this.setImplicationFx();
        this.setNegationFx();
        this.setTurnstileFx();
        this.setPredicateFx();
        this.setExistentialFx();
        this.setUniversalFx();
        super.getChildren().forEach(child -> {
            this.setThisChildrenDefaultFx(child);
        });
    }

    private void setPropositionalFx () {
        GridPane.setConstraints(this.propositional, 0, 0);
        GridPane.setColumnSpan(this.propositional, this.MAX_WIDTH);
    }

    private void setBiconditionalFx () {
        GridPane.setConstraints(this.biconditional,  0, 1);
    }

    private void setConjunctionFx () {
        GridPane.setConstraints(this.conjunction, 1, 1);
    }

    private void setDisjunctionFx () {
        GridPane.setConstraints(this.disjunction, 2, 1);
    }

    private void setDoubleTurnstileFx () {
        GridPane.setConstraints(this.doubleTurnstile, 3, 1);
    }

    private void setExclusiveDisjunctionFx () {
        GridPane.setConstraints(this.exclusiveDisjunction, 0, 2);
    }

    private void setImplicationFx () {
        GridPane.setConstraints(this.implication, 1, 2);
    }

    private void setNegationFx () {
        GridPane.setConstraints(this.negation, 2, 2);
    }

    private void setTurnstileFx () {
        GridPane.setConstraints(this.turnstile, 3, 2);
    }

    private void setPredicateFx () {
        GridPane.setConstraints(this.predicate, 0, 3);
        GridPane.setColumnSpan(this.predicate, this.MAX_WIDTH);
    }

    private void setExistentialFx () {
        GridPane.setConstraints(this.existential, 1, 4);
    }

    private void setUniversalFx () {
        GridPane.setConstraints(this.universal, 2, 4);
    }

    private void setThisChildrenDefaultFx (Node _node) {
        GridPane.setHgrow(_node, Priority.ALWAYS);
        GridPane.setVgrow(_node, Priority.ALWAYS);
        GridPane.setHalignment(_node, HPos.CENTER);
    }

}