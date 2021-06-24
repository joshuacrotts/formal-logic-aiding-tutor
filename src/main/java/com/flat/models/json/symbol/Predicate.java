package com.flat.models.json.symbol;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json Predicate object.
 */
public class Predicate extends SymbolBase {

    public Predicate (String _label, Symbols _symbols, String _toolTip, String _description, String _readAs, Axioms _axioms) {
        super(_label, _symbols, _toolTip, _description, _readAs, _axioms);
    }

}