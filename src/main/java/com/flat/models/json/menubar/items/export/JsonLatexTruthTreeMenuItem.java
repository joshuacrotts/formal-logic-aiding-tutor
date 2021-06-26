package com.flat.models.json.menubar.items.export;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLatexTruthTreeMenuItem extends Translatable {
    @Expose
    private JsonString latexTruthTree = new JsonString("LaTeX Truth Tree");

    public JsonString getLatexTruthTree() {
        return latexTruthTree;
    }

    public void setLatexTruthTree(JsonString latexTruthTree) {
        this.latexTruthTree = latexTruthTree;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(latexTruthTree);
        }};
    }

}