package com.flat.models.json.menubar.items.export;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLatexParseTreeMenuItem extends Translatable {
    @Expose
    private JsonString latexParseTree = new JsonString("LaTeX Parse Tree");

    public JsonString getLatexParseTree() {
        return latexParseTree;
    }

    public void setLatexParseTree(JsonString latexParseTree) {
        this.latexParseTree = latexParseTree;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(latexParseTree);
        }};
    }

}