package com.flat.tools.buses.eventbus.components;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class Event {

    public static enum Type {
        FORMULA_SOLVE_BUTTON_PRESSED,
        FORMULA_APPLY_BUTTON_PRESSED,
        FORMULA_INPUT,
        UNSOLVED_FORMULA,
        SOLVED_FORMULA,

        // Solver events thrown from ApplyAlgorithmAdapter.
        CLEAR_LOGIC_VISUALS,
        FORMULA_GENERATED,
        UPDATE_PARSE_TREE,
        UPDATE_TRUTH_TABLE,
        UPDATE_TRUTH_TREE,
        UPDATE_TRUTH,
        UPDATE_NATURAL_DEDUCTION,
        UPDATE_PRACTICE_PANE,
        // Practice events thrown from ApplyAlgorithmAdapter.
        EVENT_MAIN_OPERATOR_DETECTOR_PRACTICE,
        EVENT_FREE_VARIABLE_DETECTOR_PRACTICE,
        EVENT_BOUND_VARIABLE_DETECTOR_PRACTICE,
        EVENT_VACUOUS_QUANTIFIER_DETECTOR_PRACTICE,

        // Events thrown for Algorithm Visual Selection.
        PARSE_TREE_BUTTON_PRESSED,
        TRUTH_TREE_BUTTON_PRESSED,
        TRUTH_TABLE_BUTTON_PRESSED,
        NATURAL_DEDUCTION_BUTTON_PRESSED,
        PRACTICE_BUTTON_PRESSED,

        // Events thrown from logic buttons.
        LOGIC_BUTTON_PRESSED,
        LOGIC_BUTTON_CTRL_PRESSED,

        // Events thrown from Tree Pane Listener.
        TREE_NODE_LAYOUT_SET,

        // Events thrown from right pane selection.
        PRACTICE_SELECTION_BUTTON_PRESSED,
        RULES_AXIOMS_SELECTION_BUTTON_PRESSED,

        // Events thrown from practice prompt.
        PRACTICE_SUBMIT_BUTTON_PRESSED,

        // Events thrown from parse tree practice pane.
        PRACTICE_TREE_NODE_LAYOUT_SET,
    }

    private Type type;

    public Event (Type _type) {
        this.type = _type;
    }

    // Getters for object's attributes.
    public Type getType() {
        return type;
    }

    // Setters for object's attributes.
    public void setType(Type type) {
        this.type = type;
    }

}