package com.flat.view.viewdata;

import com.flat.models.json.base.keyed.base.JsonKey;
import java.util.HashMap;
import javafx.scene.text.Text;

/**
 *
 * @author christopherbrantley
 */
public class KeyedText {
    private HashMap <Class<?>, HashMap<JsonKey, Text>> data = new HashMap();

    public KeyedText () {
    }

    public Text getValue (Class<?> _key1, JsonKey _key2) {
        return this.data.get(_key1).get(_key2);
    }

    public void putValue (Class <?> _key1, JsonKey _key2, Text _value) {
        if (!this.data.containsKey(_key1))
            this.data.put(_key1, new HashMap<> ());
        this.data.get(_key1).put(_key2, _value);
    }

}