package com.flat.models.json.symbol;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json SymbolBase object.
 */
abstract class SymbolBase {
    private String label;
    private Symbols symbols;
    private String toolTip;
    private String description;
    private String readAs;
    private Axioms axioms;

    public SymbolBase (String _label, Symbols _symbols, String _toolTip,
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

    public Symbols getSymbols() {
        return symbols;
    }

    public String getToolTip() {
        return toolTip;
    }

    public String getDescription() {
        return description;
    }

    public String getReadAs() {
        return readAs;
    }

    public Axioms getAxioms() {
        return axioms;
    }

    // Setters for object's attributes.
    public void setLabel(String label) {
        this.label = label;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReadAs(String readAs) {
        this.readAs = readAs;
    }

    public void setAxioms(Axioms axioms) {
        this.axioms = axioms;
    }

    @Override
    public String toString() {
        return "SymbolBase{" + "label=" + label + ", symbols=" + symbols + ", toolTip=" + toolTip + ", description=" + description + ", readAs=" + readAs + ", axioms=" + axioms + '}';
    }

}