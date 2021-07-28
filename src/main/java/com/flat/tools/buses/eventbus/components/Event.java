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
        // Events thrown from ApplyAlgorithmAdapter.
        CLEAR_LOGIC_VISUALS,
        FORMULA_GENERATED,
        UPDATE_PARSE_TREE,
        UPDATE_TRUTH_TABLE,
        UPDATE_TRUTH_TREE,
        UPDATE_TRUTH,
        // Events thrown for Algorithm Visual Selection.
        PARSE_TREE_BUTTON_PRESSED,
        TRUTH_TREE_BUTTON_PRESSED,
        TRUTH_TABLE_BUTTON_PRESSED,
        // Events thrown from logic buttons.
        LOGIC_BUTTON_PRESSED,
        LOGIC_BUTTON_CTRL_PRESSED,
        // Events thrown from Tree Pane Listener.
        TREE_NODE_LAYOUT_SET,
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