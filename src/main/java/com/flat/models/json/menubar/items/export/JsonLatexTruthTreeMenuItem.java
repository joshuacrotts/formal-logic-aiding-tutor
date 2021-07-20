package com.flat.models.json.menubar.items.export;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonLatexTruthTreeMenuItem extends Translatable {

    public enum Keys implements JsonKey {
        LATEX_TRUTH_TREE,
    }

    private KeyedJsonString latexTruthTree = new KeyedJsonString(JsonLatexTruthTreeMenuItem.class, Keys.LATEX_TRUTH_TREE, "LaTeX Truth Tree");

    public KeyedJsonString getLatexTruthTree() {
        return latexTruthTree;
    }

    public void setLatexTruthTree(KeyedJsonString latexTruthTree) {
        this.latexTruthTree = latexTruthTree;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(latexTruthTree);
        }};
    }

}