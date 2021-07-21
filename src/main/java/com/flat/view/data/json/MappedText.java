package com.flat.view.data.json;

import com.flat.models.data.base.text.key.KeyBase;
import java.util.HashMap;
import javafx.scene.text.Text;

/**
 *
 * @author christopherbrantley
 */
public class MappedText {
    private final HashMap <Class, HashMap<KeyBase, Text>> data = new HashMap();

    public MappedText () {
    }

    public HashMap<Class, HashMap<KeyBase, Text>> getData() {
        return data;
    }

    public Text getValue (Class _key1, KeyBase _key2) {
        if (this.data.containsKey(_key1))
            if (this.data.get(_key1).containsKey(_key2))
                return this.data.get(_key1).get(_key2);
        return null;
    }

    public void putValue (Class _key1, KeyBase _key2, Text _value) {
        if (!this.data.containsKey(_key1))
            this.data.put(_key1, new HashMap<> ());
        this.data.get(_key1).put(_key2, _value);
    }

}