package com.flat.models.json.logicsymbols;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 * Structure for the Json Symbols object.
 */
public class Symbols {
    private String general;
    private List<String> alternate = new ArrayList<>();

    public Symbols(String _general, String... _alternate) {
        this.general = _general;
        this.alternate.addAll(Arrays.asList(_alternate));
    }

    // Getters for object's attributes.
    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public List<String> getAlternate() {
        return alternate;
    }

    // Setters for object's attributes.
    public void setAlternate(List<String> alternate) {
        this.alternate = alternate;
    }

    @Override
    public String toString() {
        return "Symbol{" + "general=" + general + ", alternate=" + alternate + '}';
    }

}