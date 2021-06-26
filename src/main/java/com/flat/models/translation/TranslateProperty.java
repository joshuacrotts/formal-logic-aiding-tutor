package com.flat.models.translation;

import com.flat.models.json.JsonString;
import com.google.cloud.translate.Translation;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public interface TranslateProperty {

    public LinkedList<JsonString> toTranslate ();

    public void translate ();

    public void applyTranslation (List<Translation> _translations);

}