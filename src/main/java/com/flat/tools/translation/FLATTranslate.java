package com.flat.tools.translation;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.font.FontTool;
import com.flat.tools.translation.base.TranslatableProperty;
import com.flat.tools.translation.base.TranslateProperty;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FLATTranslate {
    private Translate translator = TranslateOptions.getDefaultInstance().getService();

    public void translate(TranslateProperty _translateProperty, JsonLanguage _language) {
        _translateProperty.applyTranslation(translator.translate(_translateProperty.toTranslate(), TranslateOption.targetLanguage(_language.getCode())), FontTool.getFont(_language.getFont()));
    }

    public void translate(TranslatableProperty _translatableProperty, JsonLanguage _language) {
        List <String> curList = new LinkedList();
        _translatableProperty.toTranslate().forEach(text -> {
            curList.add(text.getText());
        });
        _translatableProperty.applyTranslation(translator.translate(curList, TranslateOption.targetLanguage(_language.getCode())), FontTool.getFont(_language.getFont()));
    }

}