package com.flat.models.data.logicsymbols.base.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.tools.translation.base.Translatable;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Axioms extends Translatable {
    private KeyedText explanation;
    private ArrayList <KeyedText> examples = new ArrayList ();

    public Axioms (KeyedText _explanation, ArrayList <KeyedText> _examples) {
        this.explanation = _explanation;
        this.examples = _examples;
    }

    // Getters for object's attributes.
    public KeyedText getExplanation() {
        return explanation;
    }

    public ArrayList<KeyedText> getExamples() {
        return examples;
    }

    // Setters for object's attributes.
    public void setExplanation(KeyedText explanation) {
        this.explanation = explanation;
    }

    public void setExamples(ArrayList<KeyedText> examples) {
        this.examples = examples;
    }

    @Override
    public LinkedList<Text> toTranslate() {
        return new LinkedList <Text> () {{
            add(explanation);
            addAll(examples);
        }};
    }

}