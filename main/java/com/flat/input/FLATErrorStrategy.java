package com.flat.input;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;

/**
 * @TODO...
 */
public class FLATErrorStrategy extends DefaultErrorStrategy {

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        super.reportNoViableAlternative(recognizer, e);
    }
}
