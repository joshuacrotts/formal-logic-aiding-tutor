package com.flat.models.data.logicsymbols.base;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbol extends Translatable {
    private KeyedText label;
    private Symbols symbols;
    private KeyedText toolTip;
    private KeyedText description;
    private KeyedText readAs;
    private Axioms axioms;

    public LogicSymbol (KeyedText _label, Symbols _symbols, KeyedText _toolTip, KeyedText _description, KeyedText _readAs, Axioms _axioms) {
        this.label = _label;
        this.symbols = _symbols;
        this.toolTip = _toolTip;
        this.description = _description;
        this.readAs = _readAs;
        this.axioms = _axioms;
    }

    // Getters for object's attributes.
    public KeyedText getLabel() {
        return label;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public KeyedText getToolTip() {
        return toolTip;
    }

    public KeyedText getDescription() {
        return description;
    }

    public KeyedText getReadAs() {
        return readAs;
    }

    public Axioms getAxioms() {
        return axioms;
    }

    // Setters for object's attributes.
    public void setLabel(KeyedText label) {
        this.label = label;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public void setToolTip(KeyedText toolTip) {
        this.toolTip = toolTip;
    }

    public void setDescription(KeyedText description) {
        this.description = description;
    }

    public void setReadAs(KeyedText readAs) {
        this.readAs = readAs;
    }

    public void setAxioms(Axioms axioms) {
        this.axioms = axioms;
    }

    @Override
    public LinkedList <Text> toTranslate() {
        return new LinkedList <Text> () {{
            add(label);
            addAll(symbols.toTranslate());
            add(toolTip);
            add(description);
            add(readAs);
            addAll(axioms.toTranslate());
        }};
    }

}