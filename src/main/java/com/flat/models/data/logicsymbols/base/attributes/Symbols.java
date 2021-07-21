package com.flat.models.data.logicsymbols.base.attributes;

import com.flat.models.data.base.text.KeyedText;
import com.flat.tools.translation.base.Translatable;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class Symbols extends Translatable {
    private KeyedText general;
    private ArrayList <KeyedText> alternate = new ArrayList ();

    public Symbols (KeyedText _general, ArrayList <KeyedText> _alternate) {
        this.general = _general;
        this.alternate = _alternate;
    }

    // Getters for object's attributes.
    public KeyedText getGeneral() {
        return general;
    }

    public ArrayList<KeyedText> getAlternate() {
        return alternate;
    }

    // Setters for object's attributes.
    public void setGeneral(KeyedText general) {
        this.general = general;
    }

    public void setAlternate(ArrayList<KeyedText> alternate) {
        this.alternate = alternate;
    }

    @Override
    public LinkedList<Text> toTranslate() {
        return new LinkedList <Text> () {{
        }};
    }

}