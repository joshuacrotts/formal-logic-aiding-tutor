package com.flat.models.json.logicsymbols.logictype.propositional;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.BiconditionalSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.conjunction.ConjunctionSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.disjunction.DisjunctionSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.doubleturnstile.DoubleTurnstileSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.exclusivedisjunction.ExclusiveDisjunctionSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.implication.ImplicationSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.negation.NegationSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.turnstile.TurnstileSymbol;
import com.flat.tools.translation.base.Translatable;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class PropositionalSymbols extends Translatable implements Serializable {

    public enum Keys implements JsonKey  {
        LABEL,
    }

    private KeyedJsonString propositional = new KeyedJsonString(PropositionalSymbols.class, Keys.LABEL, "Propositional");
    private ImplicationSymbol implication = new ImplicationSymbol();
    private BiconditionalSymbol biconditional = new BiconditionalSymbol();
    private NegationSymbol negation = new NegationSymbol();
    private ConjunctionSymbol conjunction = new ConjunctionSymbol();
    private DisjunctionSymbol disjunction = new DisjunctionSymbol();
    private ExclusiveDisjunctionSymbol exclusiveDisjunction = new ExclusiveDisjunctionSymbol();
    private TurnstileSymbol turnstile = new TurnstileSymbol();
    private DoubleTurnstileSymbol doubleTurnstile = new DoubleTurnstileSymbol();

    public PropositionalSymbols () {
    }

    // Getters for object's attributes.
    public ImplicationSymbol getImplication() {
        return implication;
    }

    public BiconditionalSymbol getBiconditional() {
        return biconditional;
    }

    public NegationSymbol getNegation() {
        return negation;
    }

    public ConjunctionSymbol getConjunction() {
        return conjunction;
    }

    public DisjunctionSymbol getDisjunction() {
        return disjunction;
    }

    public ExclusiveDisjunctionSymbol getExclusiveDisjunction() {
        return exclusiveDisjunction;
    }

    public TurnstileSymbol getTurnstile() {
        return turnstile;
    }

    public DoubleTurnstileSymbol getDoubleTurnstile() {
        return doubleTurnstile;
    }

    // Setters for object's attributes.
    public void setImplication(ImplicationSymbol implication) {
        this.implication = implication;
    }

    public void setBiconditional(BiconditionalSymbol biconditional) {
        this.biconditional = biconditional;
    }

    public void setNegation(NegationSymbol negation) {
        this.negation = negation;
    }

    public void setConjunction(ConjunctionSymbol conjunction) {
        this.conjunction = conjunction;
    }

    public void setDisjunction(DisjunctionSymbol disjunction) {
        this.disjunction = disjunction;
    }

    public void setExclusiveDisjunction(ExclusiveDisjunctionSymbol exclusiveDisjunction) {
        this.exclusiveDisjunction = exclusiveDisjunction;
    }

    public void setTurnstile(TurnstileSymbol turnstile) {
        this.turnstile = turnstile;
    }

    public void setDoubleTurnstile(DoubleTurnstileSymbol doubleTurnstile) {
        this.doubleTurnstile = doubleTurnstile;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            addAll(implication.toTranslate());
            addAll(biconditional.toTranslate());
            addAll(negation.toTranslate());
            addAll(conjunction.toTranslate());
            addAll(disjunction.toTranslate());
            addAll(exclusiveDisjunction.toTranslate());
            addAll(turnstile.toTranslate());
            addAll(doubleTurnstile.toTranslate());
        }};
    }

}