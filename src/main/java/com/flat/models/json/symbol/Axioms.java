package com.flat.models.json.symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json Axioms object.
 */
public class Axioms {
    private String explanation;
    private List<String> examples = new ArrayList<>();

    public Axioms (String _explanation, String... _examples) {
        this.explanation = _explanation;
        this.examples.addAll(Arrays.asList(_examples));
    }

    // Getters for object's attributes.
    public String getExplanation() {
        return explanation;
    }

    public List<String> getExamples() {
        return examples;
    }

    // Setters for object's attributes.
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    @Override
    public String toString() {
        return "Axioms{" + "explanation=" + explanation + ", examples=" + examples + '}';
    }

}