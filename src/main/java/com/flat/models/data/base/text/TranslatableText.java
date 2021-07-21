package com.flat.models.data.base.text;

import com.flat.controller.Controller;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.translation.base.TranslateProperty;
import com.google.cloud.translate.Translation;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TranslatableText extends Text implements TranslateProperty, Serializable {
    public TranslatableText () {
    }

    public TranslatableText (String _text) {
        super.setText(_text);
    }

    @Override
    public String toTranslate() {
        return super.getText();
    }

    @Override
    public void translate(JsonLanguage _language) {
        Controller.getTRANSLATOR().translate(this, _language);
    }

    @Override
    public void applyTranslation(Translation _translation, Font _font) {
        super.setText(_translation.getTranslatedText());
        super.setFont(_font);
    }

    @Override
    public String toString() {
        return "TranslatableText{" + "text=" + this.getText() + ", font=" + this.getFont() + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        System.out.println("here");
        try {
            os.defaultWriteObject();
            os.writeUTF(super.getText());
            os.writeUTF(super.getFont().getFamily());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            is.defaultReadObject();
            super.setText(is.readUTF());
            super.setFont(new Font(is.readUTF(), USE_PREF_SIZE));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}