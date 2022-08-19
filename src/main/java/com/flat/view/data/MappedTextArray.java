package com.flat.view.data;

import com.flat.models.data.base.text.KeyedTextArrayList;
import com.flat.models.data.base.text.key.KeyBase;

import java.util.HashMap;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class MappedTextArray {
    private final HashMap <Class, HashMap<KeyBase, KeyedTextArrayList>> data = new HashMap();

    public MappedTextArray () {
    }

    public HashMap<Class, HashMap<KeyBase, KeyedTextArrayList>> getData() {
        return data;
    }

    public KeyedTextArrayList getValue (Class _key1, KeyBase _key2) {
        if (this.data.containsKey(_key1))
            if (this.data.get(_key1).containsKey(_key2))
                return this.data.get(_key1).get(_key2);
        return null;
    }

    public void putValue (Class _key1, KeyBase _key2, KeyedTextArrayList _value) {
        if (!this.data.containsKey(_key1))
            this.data.put(_key1, new HashMap<> ());
        this.data.get(_key1).put(_key2, _value);
    }

}