package com.flat.models.json.menu;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json Option object.
 */
public class Option {
    private String label;
    private List<Option> options = new ArrayList<>();

    public Option (String _label, Option... _options) {
        this.label = _label;
        this.options.addAll(Arrays.asList(_options));
    }

    // Getters for object's attributes.
    public String getLabel() {
        return label;
    }

    public List<Option> getOptions() {
        return options;
    }

    // Setters for object's attributes.
    public void setLabel(String label) {
        this.label = label;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Option{" + "label=" + label + ", options=" + options + '}';
    }

}