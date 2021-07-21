package com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional;

import com.flat.models.json.logicsymbols.logictype.base.keyed.KeyedLogicSymbol;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes.BiconditionalAxioms;
import com.flat.models.json.logicsymbols.logictype.propositional.symbols.biconditional.attributes.BiconditionalSymbols;

/**
 *
 * @author christopherbrantley
 */
public class BiconditionalSymbol extends KeyedLogicSymbol {

    public BiconditionalSymbol () {
        super(
                BiconditionalSymbol.class,
                Type.PROPOSITIONAL,
                "Biconditional",
                new BiconditionalSymbols(),
                "Equivalence",
                "This is the equivalence button.",
                "If and only if; \"iff\"; means the same as",
                new BiconditionalAxioms());
    }

}