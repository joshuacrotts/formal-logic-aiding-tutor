package com.flat.models;

import com.flat.algorithms.predicate.PredicateNaturalDeductionValidator;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.propositional.PropositionalNaturalDeductionValidator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.algorithms.propositional.TruthTableGenerator;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TimeoutManager {
    private final static int maxValue = 1000;
    private final static int minValue = 0;

    public static boolean updateConstraints (
            int _predicateNDV, int _predicateTruthTree,
            int _propositionalNDV, int _propositionalTruthTree,
            int _truthTable
    )
    {
        if (
                validConstraint(_predicateNDV) && validConstraint (_predicateTruthTree)
                && validConstraint(_propositionalNDV) && validConstraint(_propositionalTruthTree)
                && validConstraint(_truthTable)
                )
        {
            updatePredicateNDV(_predicateNDV);
            updatePredicateTruthTree(_predicateTruthTree);
            updatePropositionalNDV(_propositionalNDV);
            updatePropositionalTruthTree(_propositionalTruthTree);
            updateTruthTable(_truthTable);
            return true;
        }
        return false;
    }

    private static void updatePredicateNDV (int _value) {
        PredicateNaturalDeductionValidator.setTimeout(_value);
    }

    private static void updatePredicateTruthTree (int _value) {
        PredicateTruthTreeGenerator.setTimeout(_value);
    }

    private static void updatePropositionalNDV (int _value) {
        PropositionalNaturalDeductionValidator.setTimeout(_value);
    }

    private static void updatePropositionalTruthTree (int _value) {
        PropositionalTruthTreeGenerator.setTimeout(_value);
    }

    private static void updateTruthTable (int _value) {
        TruthTableGenerator.setMaxAtoms(_value);
    }

    private static boolean validConstraint (int _value) {
        return minValue < _value && _value <= maxValue;
    }

    // Getters for object's attributes.
    public static int getMaxValue() {
        return maxValue;
    }

    // Setters for object's attributes.
    public static int getMinValue() {
        return minValue;
    }

}