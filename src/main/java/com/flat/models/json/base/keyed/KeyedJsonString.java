package com.flat.models.json.base.keyed;

import com.flat.controller.Controller;
import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.view.data.json.KeyedText;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class KeyedJsonString extends JsonString {
    private String key1;
    private String key2;

    private KeyedJsonString () {
        super();
        Controller.getJSON_DATA().getUpdates().add(this);
    }

    public KeyedJsonString(Class _key1, JsonKey _key2, String _string) {
        super(_string);
        this.key1 = KeyedText.toKey1(_key1);
        this.key2 = KeyedText.toKey2(_key2);
        this.updateMapText();
    }

    // Getters for object's attributes.
    public String getKey1() {
        return key1;
    }

    public String getKey2() {
        return key2;
    }

    // Setters for object's attributes.
    @Override
    public void setString(String _string) {
        super.setString(_string);
        System.out.println(_string);
        this.updateMapText();
    }

    public final Text getMappedValue () {
        if (Controller.getKEYED_TEXT().getValue(this.key1, this.key2) != null)
            return Controller.getKEYED_TEXT().getValue(this.key1, this.key2);
        return null;
    }

    public final void updateMapText () {
        if (getMappedValue() != null)
            Controller.getKEYED_TEXT().getValue(this.key1, this.key2).setText(this.getString());
        else
            Controller.getKEYED_TEXT().putValue(this.key1, this.key2, new Text(this.getString()));
    }

    public final void updateMapFont (Font _font) {
        if (getMappedValue() != null)
            getMappedValue().setFont(_font);
    }

}