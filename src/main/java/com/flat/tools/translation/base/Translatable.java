package com.flat.tools.translation.base;

import com.flat.controller.Controller;
import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;
import java.util.List;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class Translatable implements TranslatableProperty {

    @Override
    public void translate (JsonLanguage _language) {
        Controller.getTRANSLATOR().translate(this, _language);
    }

    @Override
    public void applyTranslation (List <Translation> _translations, Font _font) {
        List <Text> text = this.toTranslate();
        for (int i = 0; i < _translations.size(); i++) {
            text.get(i).setText(_translations.get(i).getTranslatedText());
        }
    }

}