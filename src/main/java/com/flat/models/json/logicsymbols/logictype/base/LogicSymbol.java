package com.flat.models.json.logicsymbols.logictype.base;

import com.flat.models.json.logicsymbols.logictype.base.attributes.Axioms;
import com.flat.models.json.logicsymbols.logictype.base.attributes.Symbols;
import com.flat.models.json.JsonString;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class LogicSymbol extends Translatable {
    private JsonString label;
    private Symbols symbols;
    private JsonString toolTip;
    private JsonString description;
    private JsonString readAs;
    private Axioms axioms;

    public LogicSymbol (String _label, Symbols _symbols, String _toolTip, String _description, String _readAs, Axioms _axioms) {
        this.label = new JsonString(_label);
        this.symbols = _symbols;
        this.toolTip = new JsonString(_toolTip);
        this.description = new JsonString(_description);
        this.readAs = new JsonString(_readAs);
        this.axioms = _axioms;
    }

    public LogicSymbol (JsonString _label, Symbols _symbols, JsonString _toolTip, JsonString _description, JsonString _readAs, Axioms _axioms) {
        this.label = _label;
        this.symbols = _symbols;
        this.toolTip = _toolTip;
        this.description = _description;
        this.readAs = _readAs;
        this.axioms = _axioms;
    }

    // Getters for object's attributes.
    public JsonString getLabel() {
        return label;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public JsonString getToolTip() {
        return toolTip;
    }

    public JsonString getDescription() {
        return description;
    }

    public JsonString getReadAs() {
        return readAs;
    }

    public Axioms getAxioms() {
        return axioms;
    }

    // Setters for object's attributes.
    public void setLabel(JsonString label) {
        this.label = label;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public void setToolTip(JsonString toolTip) {
        this.toolTip = toolTip;
    }

    public void setDescription(JsonString description) {
        this.description = description;
    }

    public void setReadAs(JsonString readAs) {
        this.readAs = readAs;
    }

    public void setAxioms(Axioms axioms) {
        this.axioms = axioms;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(label);
            add(toolTip);
            add(description);
            add(readAs);
            addAll(axioms.toTranslate());
        }};
    }

}