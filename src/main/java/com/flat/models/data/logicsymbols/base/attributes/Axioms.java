package com.flat.models.data.logicsymbols.base.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.KeyedTextArrayList;
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
public class Axioms extends Translatable implements Serializable {
    private KeyedText explanation;
    private KeyedTextArrayList examples = new KeyedTextArrayList();

    public Axioms () {
    }

    public Axioms (KeyedText _explanation, KeyedTextArrayList _examples) {
        this.explanation = _explanation;
        this.examples = _examples;
    }

    // Getters for object's attributes.
    public KeyedText getExplanation() {
        return explanation;
    }

    public KeyedTextArrayList getExamples() {
        return examples;
    }

    // Setters for object's attributes.
    public void setExplanation(KeyedText explanation) {
        this.explanation = explanation;
    }

    public void setExamples(KeyedTextArrayList examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "Axioms{" + "explanation=" + explanation + ", examples=" + examples + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.explanation);
            os.writeObject(this.examples);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.explanation = (KeyedText) is.readObject();
            this.examples = (KeyedTextArrayList) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(explanation);
            addAll(examples);
        }};
    }

}