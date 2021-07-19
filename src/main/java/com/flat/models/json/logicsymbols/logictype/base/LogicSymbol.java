package com.flat.models.json.logicsymbols.logictype.base;

import com.flat.models.json.JsonString;
import com.flat.models.json.logicsymbols.Axioms;
import com.flat.models.json.logicsymbols.Symbols;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class LogicSymbol extends Translatable {
    private String label;
    private Symbols symbols;
    private String toolTip;
    private String description;
    private String readAs;
    private Axioms axioms;

    public LogicSymbol(String _label, Symbols _symbols, String _toolTip,
                      String _description, String _readAs, Axioms _axioms) {
        this.label = _label;
        this.symbols = _symbols;
        this.toolTip = _toolTip;
        this.description = _description;
        this.readAs = _readAs;
        this.axioms = _axioms;
    }

    // Getters for object's attributes.
    public String getLabel() {
        return label;
    }

    // Setters for object's attributes.
    public void setLabel(String label) {
        this.label = label;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReadAs() {
        return readAs;
    }

    public void setReadAs(String readAs) {
        this.readAs = readAs;
    }

    public Axioms getAxioms() {
        return axioms;
    }

    public void setAxioms(Axioms axioms) {
        this.axioms = axioms;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{

        }};
    }

}