package com.flat.models.json.algorithm;

import com.flat.models.json.JsonString;
import com.flat.models.json.algorithm.enums.AlgorithmType;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonAlgorithm extends Translatable {
    private JsonString string;
    private AlgorithmType algorithmType;

    public JsonAlgorithm (String _string, AlgorithmType _algorithmType) {
        this.string = new JsonString(_string);
        this.algorithmType = _algorithmType;
    }

    // Getters for object's attributes
    public JsonString getString() {
        return string;
    }

    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }
    // Setters for object's attributes.
    public void setString(JsonString string) {
        this.string = string;
    }

    public void setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(string);
        }};
    }

}