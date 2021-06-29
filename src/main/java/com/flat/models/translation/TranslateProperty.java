package com.flat.models.translation;

import com.flat.models.json.JsonString;
import com.flat.models.json.language.JsonLanguage;
import com.google.cloud.translate.Translation;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public interface TranslateProperty {

    LinkedList<JsonString> toTranslate();

    void translate(JsonLanguage _language);

    void applyTranslation(List<Translation> _translations);

}