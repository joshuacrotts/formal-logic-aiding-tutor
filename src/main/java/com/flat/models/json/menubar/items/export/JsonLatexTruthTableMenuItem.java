package com.flat.models.json.menubar.items.export;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonLatexTruthTableMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        LATEX_TRUTH_TABLE,
    }

    private KeyedJsonString latexTruthTable = new KeyedJsonString(JsonLatexTruthTableMenuItem.class, Keys.LATEX_TRUTH_TABLE, "LaTeX Truth Table");

    public KeyedJsonString getLatexTruthTable() {
        return latexTruthTable;
    }

    public void setLatexTruthTable(KeyedJsonString latexTruthTable) {
        this.latexTruthTable = latexTruthTable;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(latexTruthTable);
        }};
    }

}