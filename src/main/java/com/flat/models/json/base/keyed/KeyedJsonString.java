package com.flat.models.json.base.keyed;

import com.flat.controller.Controller;
import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class KeyedJsonString extends JsonString {
    private final Class<?> key1;
    private final JsonKey key2;
    private final Text value = new Text("");

    public KeyedJsonString(Class<?> _key1, JsonKey _key2, String _string) {
        super(_string);
        this.key1 = _key1;
        this.key2 = _key2;
        this.value.setText(_string);
        this.addToMap();
    }

    // Getters for object's attributes.
    public Class<?> getKey1() {
        return key1;
    }

    public JsonKey getKey2() {
        return key2;
    }

    public Text getValue() {
        return value;
    }

    // Setters for object's attributes.
    @Override
    public void setString(String _string) {
        super.setString(_string);
        this.updateValue(_string);
    }

    public void updateValue (String _string) {
        this.value.setText(_string);
    }

    private void addToMap () {
        Controller.getKEYED_TEXT().putValue(this.key1, this.key2, this.value);
    }

}