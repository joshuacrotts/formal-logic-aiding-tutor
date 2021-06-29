package com.flat.input;

import com.flat.FLATLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;

import java.util.*;

/**
 * This class can be added to either the lexer or the parser error reporting
 * chains (or both). All it does is keep track of whether an error was detected,
 * so after parsing you can call sawError() to see if there was a problem.
 * <p>
 * For FLAT, we can use this in the front-end for displaying error messages.
 * Simply call FLATErrorListener.getErrorIterator() and
 * FLATErrorListener.getWarningIterator() to get an Iterator object for them.
 *
 * @author Joshua Crotts
 * @modified 2/20/2021
 */
public class FLATErrorListener extends BaseErrorListener {

    /**
     * Set of all compiler errors generated while parsing.
     */
    private static final Set<Message> errors = new HashSet<>();

    /**
     * Set of all warning errors generated while parsing.
     */
    private static final Set<Message> warnings = new HashSet<>();

    /**
     * Keeps track of whether we have encountered an error or not.
     */
    private static boolean gotError = false;

    /**
     * Keeps track of whether we have encountered a warning or not.
     */
    private static boolean gotWarning = false;

    public FLATErrorListener() {
        super();
    }

    /**
     * Prints an error message to the console with the line and column number
     * specified by the parameters. The error flag is also set.
     *
     * @param colNo
     * @param errorMsg
     */
    public static void syntaxError(int colNo, String errorMsg) {
        FLATErrorListener.gotError = true;
        FLATErrorListener.errors.add(new Message(errorMsg, colNo));
    }

    /**
     * Prints an error message to the console with the line and column number
     * specified by the ParserRuleContext. The error flag is also set.
     *
     * @param ctx
     * @param errorMsg
     */
    public static void syntaxError(ParserRuleContext ctx, String errorMsg) {
        FLATErrorListener.gotError = true;
        int lineNo = -1;
        int colNo = -1;

        if (ctx != null) {
            lineNo = ctx.start.getLine();
            colNo = ctx.start.getCharPositionInLine();
        } else {
            throw new IllegalArgumentException(
                    "Internal compiler error - ParserRuleContext cannot be null in ErrorListener.");
        }

        FLATErrorListener.errors.add(new Message(errorMsg, colNo));
    }

    /**
     * Prints an warning message to the console with the line and column number
     * specified by the ParserRuleContext.
     *
     * @param ctx
     * @param warningMsg
     * @return void.
     */
    public static void syntaxWarning(ParserRuleContext ctx, String warningMsg) {
        FLATErrorListener.gotWarning = true;
        int lineNo = -1;
        int colNo = -1;

        if (ctx != null) {
            lineNo = ctx.start.getLine();
            colNo = ctx.start.getCharPositionInLine();
        } else {
            throw new IllegalArgumentException(
                    "Internal compiler error - ParserRuleContext cannot be null in ErrorListener.");
        }

        FLATErrorListener.warnings.add(new Message(warningMsg, colNo));
    }

    /**
     * Prints error messages generated through parsing the syntax tree to standard
     * error.
     *
     * @return void.
     */
    public static void printErrors() {
        List<Message> errorList = new ArrayList<Message>(FLATErrorListener.errors);
        errorList.sort(Comparator.comparing(Message::getColNo));
        System.err.print("ERRORS(" + FLATErrorListener.errors.size() + "):\n");
        for (Message error : errorList) {
            System.err.println(error);
        }
    }

    /**
     * Prints warning messages generated through parsing the syntax tree to standard
     * out.
     *
     * @return void.
     */
    public static void printWarnings() {
        List<Message> warningList = new ArrayList<Message>(FLATErrorListener.warnings);
        warningList.sort(Comparator.comparing(Message::getColNo));
        System.out.print("WARNINGS(" + FLATErrorListener.warnings.size() + "):\n");
        for (Message warning : warningList) {
            System.out.println(warning);
        }
    }

    /**
     * Was an error encountered?
     *
     * @return true if an error was seen.
     */
    public static boolean sawError() {
        return gotError;
    }

    /**
     * Was a warning encountered? This probably serves little use.
     *
     * @return true if a warning was seen.
     */
    public static boolean sawWarning() {
        return gotWarning;
    }

    /**
     * Returns an Iterator object for the errors generated during
     * parsing and semantic analysis.
     *
     * @return Iterator<Message> object.
     */
    public static Iterator<Message> getErrorIterator() {
        return errors.iterator();
    }

    /**
     * Returns an Iterator object for the warnings generated during
     * parsing and semantic analysis.
     *
     * @return Iterator<Message> object.
     */
    public static Iterator<Message> getWarningIterator() {
        return warnings.iterator();
    }

    /**
     * Since this is a static error listener, we need to reset the warnings and
     * errors each time we use this in a unit testing environment or we'll have
     * false positives.
     */
    public static void reset() {
        FLATErrorListener.warnings.clear();
        FLATErrorListener.errors.clear();
        FLATErrorListener.gotError = false;
        FLATErrorListener.gotWarning = false;
    }

    /**
     * This is the syntaxError method from the BaseErrorListener ANTLR class. We have
     * overridden it to set the error flag and add a new Message to our running set of
     * objects.
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int col, String errorMsg,
                            RecognitionException e) {
        // Lexer errors should always generate an unrecognized character message.
        if (recognizer instanceof Lexer) {
            Lexer lexer = (Lexer) recognizer;
            CharStream input = lexer.getInputStream();
            String offTok = lexer.getErrorDisplay(input.getText(new Interval(lexer._tokenStartCharIndex, input.index())));
            errorMsg = "Unrecognized character: '" + offTok + "'";
        } else {
            Token offTok = (Token) offendingSymbol;
            int tokId = offTok.getType();
            // If it's a closing parenthesis, that means we have one too many.
            if (tokId == FLATLexer.CLOSE_PAREN) {
                errorMsg = "Extra closing ')' parentheses (is there more than one?)";
            } else if (tokId == FLATLexer.EOF) {
                errorMsg = "Missing closing ')' parenthesis";
            } else {
                errorMsg = "Invalid input (usually because of an invalid character or a missing opening '(' parenthesis)";
            }
        }

        gotError = true;
        FLATErrorListener.errors.add(new Message(errorMsg, col + 1));
    }

    /**
     * @author joshuacrotts
     */
    public static class Message {
        private final String text;
        private final int colNo;

        public Message(String text, int colNo) {
            this.text = text;
            this.colNo = colNo;
        }

        @Override
        public boolean equals(Object msg) {
            Message oMsg = (Message) msg;
            return this.text.equals(oMsg.text)
                    && this.colNo == oMsg.colNo;
        }

        @Override
        public int hashCode() {
            return this.text.hashCode() + this.colNo;
        }

        public int getColNo() {
            return this.colNo;
        }

        @Override
        public String toString() {
            return "Position " + this.colNo + ": " + this.text;
        }
    }
}
