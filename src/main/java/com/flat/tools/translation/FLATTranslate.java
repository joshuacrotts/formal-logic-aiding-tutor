package com.flat.tools.translation;

import com.flat.controller.Controller;
import com.flat.models.translation.TranslateProperty;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FLATTranslate {

    public static void translate (TranslateProperty _translateProperty) {
        List<String> curList = new LinkedList<>();
        _translateProperty.toTranslate().forEach((jsonString) -> {
                    curList.add(jsonString.getString());
        });
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        List<Translation> translations = translate.translate(curList, TranslateOption.targetLanguage(Controller.getLanguage().getCode()));
        _translateProperty.applyTranslation(translations);
    }

}