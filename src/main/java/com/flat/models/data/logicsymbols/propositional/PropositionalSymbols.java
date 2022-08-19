package com.flat.models.data.logicsymbols.propositional;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.logicsymbols.propositional.biconditional.BiconditionalSymbol;
import com.flat.models.data.logicsymbols.propositional.conjunction.ConjunctionSymbol;
import com.flat.models.data.logicsymbols.propositional.disjunction.DisjunctionSymbol;
import com.flat.models.data.logicsymbols.propositional.doubleturnstile.DoubleTurnstileSymbol;
import com.flat.models.data.logicsymbols.propositional.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import com.flat.models.data.logicsymbols.propositional.implication.ImplicationSymbol;
import com.flat.models.data.logicsymbols.propositional.negation.NegationSymbol;
import com.flat.models.data.logicsymbols.propositional.turnstile.TurnstileSymbol;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class PropositionalSymbols extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LABEL,
    }

    private KeyedText propositional = new KeyedText(PropositionalSymbols.class, Keys.LABEL, "Propositional");
    private BiconditionalSymbol biconditional = new BiconditionalSymbol();
    private ConjunctionSymbol conjunction = new ConjunctionSymbol();
    private DisjunctionSymbol disjunction = new DisjunctionSymbol();
    private DoubleTurnstileSymbol doubleTurnstile = new DoubleTurnstileSymbol();
    private ExclusiveDisjunctionSymbol exclusiveDisjunction = new ExclusiveDisjunctionSymbol();
    private ImplicationSymbol implication = new ImplicationSymbol();
    private NegationSymbol negation = new NegationSymbol();
    private TurnstileSymbol turnstile = new TurnstileSymbol();

    public PropositionalSymbols () {
    }

    // Getters for object's attributes.
    public BiconditionalSymbol getBiconditional() {
        return biconditional;
    }

    public ConjunctionSymbol getConjunction() {
        return conjunction;
    }

    public DisjunctionSymbol getDisjunction() {
        return disjunction;
    }

    public DoubleTurnstileSymbol getDoubleTurnstile() {
        return doubleTurnstile;
    }

    public ExclusiveDisjunctionSymbol getExclusiveDisjunction() {
        return exclusiveDisjunction;
    }

    public ImplicationSymbol getImplication() {
        return implication;
    }

    public NegationSymbol getNegation() {
        return negation;
    }

    public TurnstileSymbol getTurnstile() {
        return turnstile;
    }

    // Setters for object's attributes.
    public void setBiconditional(BiconditionalSymbol biconditional) {
        this.biconditional = biconditional;
    }

    public void setConjunction(ConjunctionSymbol conjunction) {
        this.conjunction = conjunction;
    }

    public void setDisjunction(DisjunctionSymbol disjunction) {
        this.disjunction = disjunction;
    }

    public void setDoubleTurnstile(DoubleTurnstileSymbol doubleTurnstile) {
        this.doubleTurnstile = doubleTurnstile;
    }

    public void setExclusiveDisjunction(ExclusiveDisjunctionSymbol exclusiveDisjunction) {
        this.exclusiveDisjunction = exclusiveDisjunction;
    }

    public void setImplication(ImplicationSymbol implication) {
        this.implication = implication;
    }

    public void setNegation(NegationSymbol negation) {
        this.negation = negation;
    }

    public void setTurnstile(TurnstileSymbol turnstile) {
        this.turnstile = turnstile;
    }

    @Override
    public String toString() {
        return "PropositionalSymbols{" + "biconditional=" + biconditional + ", conjunction=" + conjunction + ", disjunction=" + disjunction + ", doubleTurnstile=" + doubleTurnstile + ", exclusiveDisjunction=" + exclusiveDisjunction + ", implication=" + implication + ", negation=" + negation + ", turnstile=" + turnstile + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.propositional);
            os.writeObject(this.biconditional);
            os.writeObject(this.conjunction);
            os.writeObject(this.disjunction);
            os.writeObject(this.doubleTurnstile);
            os.writeObject(this.exclusiveDisjunction);
            os.writeObject(this.implication);
            os.writeObject(this.negation);
            os.writeObject(this.turnstile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.propositional = (KeyedText) is.readObject();
            this.biconditional = (BiconditionalSymbol) is.readObject();
            this.conjunction = (ConjunctionSymbol) is.readObject();
            this.disjunction = (DisjunctionSymbol) is.readObject();
            this.doubleTurnstile = (DoubleTurnstileSymbol) is.readObject();
            this.exclusiveDisjunction = (ExclusiveDisjunctionSymbol) is.readObject();
            this.implication = (ImplicationSymbol) is.readObject();
            this.negation = (NegationSymbol) is.readObject();
            this.turnstile = (TurnstileSymbol) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(propositional);
            addAll(biconditional.toTranslate());
            addAll(conjunction.toTranslate());
            addAll(disjunction.toTranslate());
            addAll(doubleTurnstile.toTranslate());
            addAll(exclusiveDisjunction.toTranslate());
            addAll(implication.toTranslate());
            addAll(negation.toTranslate());
            addAll(turnstile.toTranslate());
        }};
    }

}