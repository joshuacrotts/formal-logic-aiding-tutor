package com.flat.view.data;

import java.util.HashMap;
import javafx.scene.text.Text;

/**
 *
 * @author christopherbrantley
 */
public class KeyedText {
    private HashMap <String, HashMap<String, Text>> data = new HashMap();

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

    public void putValue (String _key1, String _key2, Text _value) {
        if (!this.data.containsKey(_key1))
            this.data.put(_key1, new HashMap<> ());
        this.data.get(_key1).put(_key2, _value);
    }

}