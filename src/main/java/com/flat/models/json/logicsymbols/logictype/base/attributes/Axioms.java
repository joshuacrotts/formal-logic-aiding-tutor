package com.flat.models.json.logicsymbols.logictype.base.attributes;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 * Structure for the Json Axioms object.
 */
public class Axioms extends Translatable {
    private JsonString explanation;
    private ArrayList <JsonString> examples = new ArrayList ();

    public Axioms (String _explanation, ArrayList <String> _examples) {
        this.explanation = new JsonString(_explanation);
        _examples.forEach(example -> {
            this.examples.add(new JsonString(example));
        });
    }

    public Axioms(JsonString _explanation, ArrayList <JsonString> _examples) {
        this.explanation = _explanation;
        this.examples = _examples;
    }

    // Getters for object's attributes.
    public JsonString getExplanation() {
        return explanation;
    }

    public ArrayList <JsonString> getExamples() {
        return examples;
    }

    // Setters for object's attributes.
    public void setExplanation(JsonString explanation) {
        this.explanation = explanation;
    }

    public void setExamples(ArrayList <JsonString> examples) {
        this.examples = examples;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(explanation);
            addAll(examples);
        }};
    }

}