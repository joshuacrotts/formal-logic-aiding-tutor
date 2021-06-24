package com.flat.models.json.menu;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json Tab object.
 */
public class Tab {
    private String label;
    private List<Option> options = new ArrayList<>();;

    public Tab (String _label, Option... _options) {
        this.label = _label;
        this.options.addAll(Arrays.asList(_options));
    }

    // Getters for object's attributes.
    public List<Option> getOptions() {
        return options;
    }

    public String getLabel() {
        return label;
    }

    // Setters for object's attributes.
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Tab{" + "label=" + label + ", options=" + options + '}';
    }

}