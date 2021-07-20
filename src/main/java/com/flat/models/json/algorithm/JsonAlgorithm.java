package com.flat.models.json.algorithm;

import com.flat.models.json.algorithm.enums.AlgorithmType;
import com.flat.models.json.base.JsonString;
import com.flat.tools.translation.base.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonAlgorithm extends Translatable {
    private JsonString jsonString;
    private AlgorithmType algorithmType;

    public JsonAlgorithm (JsonString _string, AlgorithmType _algorithmType) {
        this.jsonString = _string;
        this.algorithmType = _algorithmType;
    }

    // Getters for object's attributes
    public JsonString getJsonString() {
        return jsonString;
    }

    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }
    // Setters for object's attributes.
    public void setJsonString(JsonString jsonString) {
        this.jsonString = jsonString;
    }

    public void setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString> () {{
            add(jsonString);
        }};
    }

}