package com.flat.models.json.logicsymbols.logictype.base.attributes.axioms;

import com.flat.models.json.base.JsonString;
import com.flat.tools.translation.base.Translatable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 * Structure for the Json Axioms object.
 */
public class Axioms extends Translatable {
    private JsonString explanation;
    private ArrayList <JsonString> examples = new ArrayList ();

    public Axioms () {
    }

    public Axioms(String _explanation, ArrayList <String> _examples) {
        this.explanation = new JsonString(_explanation);
        _examples.forEach(example -> {
            this.examples.add(new JsonString(example));
        });
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
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(explanation);
            addAll(examples);
        }};
    }

}