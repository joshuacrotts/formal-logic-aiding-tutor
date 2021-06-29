package com.flat.input;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;

/**
 * @TODO...
 */
public class FLATErrorStrategy extends DefaultErrorStrategy {
    @Override
    protected Token getMissingSymbol(Parser recognizer) {
        System.out.println("Missing...?");
        return super.getMissingSymbol(recognizer);
    }
}
