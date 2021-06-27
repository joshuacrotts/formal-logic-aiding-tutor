package com.flat.models.json.menubar.items.export;

import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLatexTruthTableMenuItem extends Translatable {
    private JsonString latexTruthTable = new JsonString("LaTeX Truth Table");

    public JsonString getLatexTruthTable() {
        return latexTruthTable;
    }

    public void setLatexTruthTable(JsonString latexTruthTable) {
        this.latexTruthTable = latexTruthTable;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(latexTruthTable);
        }};
    }

}