package com.flat.models.data.algorithms.base;

import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class Algorithm extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LABEL,
    }

    private KeyedText label;
    private AlgorithmType type;

    public Algorithm () {
    }

    public Algorithm (KeyedText _label, AlgorithmType _type) {
        this.label = _label;
        this.type = _type;
    }

    // Getters for object's attributes.
    public KeyedText getLabel() {
        return label;
    }

    public AlgorithmType getType() {
        return type;
    }

    // Setters for object's attributes.
    public void setLabel(KeyedText label) {
        this.label = label;
    }

    public void setType(AlgorithmType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Algorithm{" + "label=" + label + ", type=" + type + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.label);
            os.writeObject(this.type);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.label = (KeyedText) is.readObject();
            this.type = (AlgorithmType) is.readObject();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(label);
        }};
    }

}