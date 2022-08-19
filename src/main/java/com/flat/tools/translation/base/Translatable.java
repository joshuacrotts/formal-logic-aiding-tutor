package com.flat.tools.translation.base;

import com.flat.controller.Controller;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public abstract class Translatable implements TranslatableProperty {

    @Override
    public void translate (JsonLanguage _language) {
        Controller.TRANSLATOR.translate(this, _language);
    }

    @Override
    public void applyTranslation (List <Translation> _translations, Font _font) {
        List <TranslatableText> text = this.toTranslate();
        for (int i = 0; i < _translations.size(); i++) {
            text.get(i).applyTranslation(_translations.get(i), _font);
        }
    }

}