package com.flat.models;

import com.flat.algorithms.predicate.PredicateNaturalDeductionValidator;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalNaturalDeductionValidator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.algorithms.propositional.TruthTableGenerator;
import com.flat.tools.FLATUtils;
import javafx.scene.text.Text;
import org.junit.platform.commons.util.StringUtils;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TimeoutManager {
    private final static int maxValue = 1000;
    private final static int minValue = 0;
    private final static Text PREDICATE_NDV = new Text("100");
    private final static Text PREDICATE_TRUTH_TREE = new Text("100");
    private final static Text PROPOSITIONAL_NDV = new Text("100");
    private final static Text PROPOSITIONAL_TRUTH_TREE = new Text("100");
    private final static Text TRUTH_TABLE = new Text("100");

    public static boolean updateConstraints ()
    {
        if (
                validConstraint(PREDICATE_NDV) && validConstraint (PREDICATE_TRUTH_TREE)
                && validConstraint(PROPOSITIONAL_NDV) && validConstraint(PROPOSITIONAL_TRUTH_TREE)
                && validConstraint(TRUTH_TABLE)
                )
        {
            updatePredicateNDV();
            updatePredicateTruthTree();
            updatePropositionalNDV();
            updatePropositionalTruthTree();
            updateTruthTable();
            return true;
        }
        return false;
    }

    private static void updatePredicateNDV () {
        PredicateNaturalDeductionValidator.setTimeout(textToNumeric(PREDICATE_NDV));
    }

    private static void updatePredicateTruthTree () {
        PredicateTruthTreeGenerator.setTimeout(textToNumeric(PREDICATE_TRUTH_TREE));
    }

    private static void updatePropositionalNDV () {
        PropositionalNaturalDeductionValidator.setTimeout(textToNumeric(PROPOSITIONAL_NDV));
    }

    private static void updatePropositionalTruthTree () {
        PropositionalTruthTreeGenerator.setTimeout(textToNumeric(PROPOSITIONAL_TRUTH_TREE));
    }

    private static void updateTruthTable () {
        TruthTableGenerator.setMaxAtoms(textToNumeric(TRUTH_TABLE));
    }

    private static boolean validConstraint (int _value) {
        return minValue < _value && _value <= maxValue;
    }

    private static boolean validConstraint(Text _value) {
        return validConstraint(textToNumeric(_value));
    }

    private static int textToNumeric (Text _text) {
        if (FLATUtils.isNumeric(_text.getText()))
            return Integer.parseInt(_text.getText());
        return Integer.MIN_VALUE;
    }

    // Getters for object's attributes.
    public static int getMaxValue() {
        return maxValue;
    }

    public static Text getPREDICATE_NDV() {
        return PREDICATE_NDV;
    }

    public static Text getPREDICATE_TRUTH_TREE() {
        return PREDICATE_TRUTH_TREE;
    }

    public static Text getPROPOSITIONAL_NDV() {
        return PROPOSITIONAL_NDV;
    }

    public static Text getPROPOSITIONAL_TRUTH_TREE() {
        return PROPOSITIONAL_TRUTH_TREE;
    }

    public static Text getTRUTH_TABLE() {
        return TRUTH_TABLE;
    }

    public static int getMinValue() {
        return minValue;
    }

}