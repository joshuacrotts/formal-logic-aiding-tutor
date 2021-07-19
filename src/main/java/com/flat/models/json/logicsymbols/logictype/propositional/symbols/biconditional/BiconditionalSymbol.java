package com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional;

import com.flat.models.json.logicsymbols.logictype.base.LogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes.BiconditionalAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes.BiconditionalSymbols;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbol extends LogicSymbol {

    public BiconditionalSymbol () {
        super("Biconditional",
                new BiconditionalSymbols(),
                "Equivalence",
                "This is the equivalence button.",
                "If and only if; \"iff\"; means the same as",
                new BiconditionalAxioms());
    }

}