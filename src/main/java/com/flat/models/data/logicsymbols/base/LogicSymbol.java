package com.flat.models.data.logicsymbols.base;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.logicsymbols.base.attributes.Axioms;
import com.flat.models.data.logicsymbols.base.attributes.Symbols;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LogicSymbol extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
            LABEL,
            // Symbol's keys.
            GENERAL,
            ALTERNATE,
            ALTERNATE_1,
            ALTERNATE_2,
            ALTERNATE_3,
            ALTERNATE_4,
            ALTERNATE_5,
            ALTERNATE_6,
            ALTERNATE_7,
            // Symbol's keys.
            TOOL_TIP,
            DESCRIPTION,
            READ_AS,
            // Axioms's keys.
            EXPLANATION,
            EXAMPLES,
            EXAMPLE_1,
            EXAMPLE_2,
            EXAMPLE_3,
            EXAMPLE_4,
            EXAMPLE_5,
            EXAMPLE_6,
            EXAMPLE_7,
            // Axiom's keys.
        }

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
    public String toString() {
        return "LogicSymbol{" + "label=" + label + ", symbols=" + symbols + ", toolTip=" +
                toolTip + ", description=" + description + ", readAs=" + readAs + ", axioms=" + axioms + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.label);
            os.writeObject(this.symbols);
            os.writeObject(this.toolTip);
            os.writeObject(this.description);
            os.writeObject(this.readAs);
            os.writeObject(this.axioms);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.label = (KeyedText) is.readObject();
            this.symbols = (Symbols) is.readObject();
            this.toolTip = (KeyedText) is.readObject();
            this.description = (KeyedText) is.readObject();
            this.readAs = (KeyedText) is.readObject();
            this.axioms = (Axioms) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(label);
            addAll(symbols.toTranslate());
            add(toolTip);
            add(description);
            add(readAs);
            addAll(axioms.toTranslate());
        }};
    }

}