package com.flat.models.data.rulesaxioms;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class RulesAxioms extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        NAME,
        FORMAL_NAME,
        ALTERNATIVE_SYMBOLS,
        EXPLANATION,
        EXAMPLES
    }

    private KeyedText name = new KeyedText(RulesAxioms.class, Keys.NAME, "Name");
    private KeyedText formalName = new KeyedText(RulesAxioms.class, Keys.FORMAL_NAME, "Formal Name");
    private KeyedText alternativeSymbols = new KeyedText(RulesAxioms.class, Keys.ALTERNATIVE_SYMBOLS, "Alternative Symbols");
    private KeyedText explanation = new KeyedText(RulesAxioms.class, Keys.EXPLANATION, "Explanation");
    private KeyedText examples = new KeyedText(RulesAxioms.class, Keys.EXAMPLES, "Examples");

    public RulesAxioms () {
    }

    // Getters for object's attributes.
    public KeyedText getName() {
        return name;
    }

    public KeyedText getFormalName() {
        return formalName;
    }

    public KeyedText getAlternativeSymbols() {
        return alternativeSymbols;
    }

    public KeyedText getExplanation() {
        return explanation;
    }

    public KeyedText getExamples() {
        return examples;
    }

    // Setters for object's attributes.
    public void setName(KeyedText name) {
        this.name = name;
    }

    public void setFormalName(KeyedText formalName) {
        this.formalName = formalName;
    }

    public void setAlternativeSymbols(KeyedText alternativeSymbols) {
        this.alternativeSymbols = alternativeSymbols;
    }

    public void setExplanation(KeyedText explanation) {
        this.explanation = explanation;
    }

    public void setExamples(KeyedText examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "RulesAxioms{" + "name=" + name + ", formalName=" + formalName + ", alternativeSymbols=" + alternativeSymbols + ", explanation=" + explanation + ", examples=" + examples + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.name);
            os.writeObject(this.formalName);
            os.writeObject(this.alternativeSymbols);
            os.writeObject(this.explanation);
            os.writeObject(this.examples);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.name = (KeyedText) is.readObject();
            this.formalName = (KeyedText) is.readObject();
            this.alternativeSymbols = (KeyedText) is.readObject();
            this.explanation = (KeyedText) is.readObject();
            this.examples = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(name);
            add(formalName);
            add(alternativeSymbols);
            add(explanation);
            add(examples);
        }};
    }

}