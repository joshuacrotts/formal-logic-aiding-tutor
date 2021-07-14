package com.flat.tools.eventbus.base;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class Event {

    public enum Type {
        FORMULA_SOLVE_BUTTON_PRESSED,
        FORMULA_APPLY_BUTTON_PRESSED,
        FORMULA_INPUT,
        UNSOLVED_FORMULA,
        SOLVED_FORMULA,
        // Events thrown from ApplyAlgorithmAdapter.
        CLEAR_LOGIC_VISUALS,
        FORMULA_GENERATED,
        UPDATE_PARSE_TREE,
        UPDATE_TRUTH_TABLE,
        UPDATE_TRUTH_TREE,
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