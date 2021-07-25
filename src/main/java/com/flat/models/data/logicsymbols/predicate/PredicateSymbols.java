package com.flat.models.data.logicsymbols.predicate;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.data.logicsymbols.predicate.existential.ExistentialSymbol;
import com.flat.models.data.logicsymbols.predicate.universal.UniversalSymbol;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class PredicateSymbols extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        LABEL,
    }

    private KeyedText predicate = new KeyedText(PredicateSymbols.class, Keys.LABEL, "Predicate");
    private ExistentialSymbol existential = new ExistentialSymbol();
    private UniversalSymbol universal = new UniversalSymbol();

    public PredicateSymbols () {
    }

    // Getters for object's attributes.
    public ExistentialSymbol getExistential() {
        return existential;
    }

    public UniversalSymbol getUniversal() {
        return universal;
    }

    // Setters for object's attributes.
    public void setExistential(ExistentialSymbol existential) {
        this.existential = existential;
    }

    public void setUniversal(UniversalSymbol universal) {
        this.universal = universal;
    }

    @Override
    public String toString() {
        return "PredicateSymbols{" + "existential=" + existential + ", universal=" + universal + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.existential);
            os.writeObject(this.universal);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.existential = (ExistentialSymbol) is.readObject();
            this.universal = (UniversalSymbol) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(predicate);
            addAll(existential.toTranslate());
            addAll(universal.toTranslate());
        }};
    }

}