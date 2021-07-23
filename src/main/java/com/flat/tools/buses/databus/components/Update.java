package com.flat.tools.buses.databus.components;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Update {

    public static enum Type {
        APPLICABLE_ALGORITHMS,
    }

    private Type type;

    public Update (Type _type) {
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