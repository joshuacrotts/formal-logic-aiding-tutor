package com.flat.tools.translation.base;
import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;
import javafx.scene.text.Font;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public interface TranslateProperty {

    String toTranslate();

    void translate (JsonLanguage _language);

    void applyTranslation (Translation _translations, Font _font);

}