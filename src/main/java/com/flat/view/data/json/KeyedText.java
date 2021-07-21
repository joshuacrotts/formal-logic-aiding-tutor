package com.flat.view.data.json;

import com.flat.models.json.base.keyed.base.JsonKey;
import java.util.HashMap;
import javafx.scene.text.Text;

/**
 *
 * @author christopherbrantley
 */
public class KeyedText {
    private final HashMap <String, HashMap<String, Text>> data = new HashMap();

    public KeyedText () {
    }

    public HashMap<String, HashMap<String, Text>> getData() {
        return data;
    }

    public Text getValue (String _key1, String _key2) {
        if (this.data.containsKey(_key1))
            if (this.data.get(_key1).containsKey(_key2))
                return this.data.get(_key1).get(_key2);
        return null;
    }

    public Text getValue (Class _key1, JsonKey _key2) {
        return this.getValue(KeyedText.toKey1(_key1), KeyedText.toKey2(_key2));
    }

    public void putValue (String _key1, String _key2, Text _value) {
        if (!this.data.containsKey(_key1))
            this.data.put(_key1, new HashMap<> ());
        this.data.get(_key1).put(_key2, _value);
    }

    public static String toKey1 (Class _class) {
        return _class.getSimpleName();
    }

    public static String toKey2 (JsonKey _jsonKey) {
        return _jsonKey.toString();
    }

}