package com.flat.models.json.menubar.items.export;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonLatexParseTreeMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        LATEX_PARSE_TREE,
    }

    private KeyedJsonString latexParseTree = new KeyedJsonString(JsonLatexParseTreeMenuItem.class, Keys.LATEX_PARSE_TREE, "LaTeX Parse Tree");

    public KeyedJsonString getLatexParseTree() {
        return latexParseTree;
    }

    public void setLatexParseTree(KeyedJsonString latexParseTree) {
        this.latexParseTree = latexParseTree;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(latexParseTree);
        }};
    }

}