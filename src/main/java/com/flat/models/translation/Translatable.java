package com.flat.models.translation;

import com.flat.models.json.JsonString;
import com.flat.tools.translation.FLATTranslate;
import com.google.cloud.translate.Translation;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public abstract class Translatable implements TranslateProperty {

    @Override
    public void translate () {
        FLATTranslate.translate(this);
    };

    @Override
    public void applyTranslation(List<Translation> _translations) {
        List<JsonString> jsonStrings = this.toTranslate();
        for (int i = 0; i < _translations.size(); i++) {
            jsonStrings.get(i).setString(_translations.get(i).getTranslatedText());
        }
    }

}