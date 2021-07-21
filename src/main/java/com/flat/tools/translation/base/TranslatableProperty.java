package com.flat.tools.translation.base;

import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public interface TranslatableProperty {

    LinkedList <Text> toTranslate();

    void translate (JsonLanguage _language);

    void applyTranslation (List <Translation> _translations, Font _font);

}