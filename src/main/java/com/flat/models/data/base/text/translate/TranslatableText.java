package com.flat.models.data.base.text.translate;

import com.flat.controller.Controller;
import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.translation.base.TranslateProperty;
import com.google.cloud.translate.Translation;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static javafx.scene.layout.Region.USE_PREF_SIZE;

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
        Controller.TRANSLATOR.translate(this, _language);
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
        try {
            os.writeUTF(super.getText());
            os.writeUTF(super.getFont().getFamily());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            super.setText(is.readUTF());
            super.setFont(new Font(is.readUTF(), USE_PREF_SIZE));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}