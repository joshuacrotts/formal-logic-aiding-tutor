package com.flat.models.json.logicsymbols.logictype.base.attributes.symbols;

import java.util.ArrayList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 * Structure for the Json Symbols object.
 */
public class Symbols {
    private String general;
    private ArrayList <String> alternate = new ArrayList ();

    public Symbols(String _general, ArrayList <String> _alternate) {
        this.general = _general;
        this.alternate = _alternate;
    }

    // Getters for object's attributes.
    public String getGeneral () {
        return general;
    }

    public ArrayList <String> getAlternate () {
        return alternate;
    }

    // setters for object's attributes.
    public void setGeneral (String general) {
        this.general = general;
    }

    public void setAlternate (ArrayList <String> alternate) {
        this.alternate = alternate;
    }

}