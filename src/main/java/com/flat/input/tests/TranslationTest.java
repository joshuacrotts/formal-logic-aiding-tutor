package com.flat.input.tests;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class TranslationTest {

    public static void main(String[] args) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate("Hola mundo");
        System.out.printf("Translated text:\n\t%s\n", translation.getTranslatedText());
    }
}
