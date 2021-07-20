package com.flat.tools.translation.base;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public interface TranslateProperty {

    LinkedList <JsonString> toTranslate();

    void translate (JsonLanguage _language);

    void applyTranslation (List<Translation> _translations);

}