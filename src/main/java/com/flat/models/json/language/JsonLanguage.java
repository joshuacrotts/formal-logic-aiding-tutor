package com.flat.models.json.language;

import com.flat.tools.font.enums.FontLocal.FontFamily;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json JsonLanguage object.
 */
public class JsonLanguage {
    public final static JsonLanguage NONE = new JsonLanguage("", "", "", FontFamily.DEFAULT);
    public final static JsonLanguage DEFAULT = new JsonLanguage("English", "English", "en", FontFamily.DEFAULT);

    private final String languageName;
    private final String nativeName;
    private final String code;
    private final FontFamily font;

    public JsonLanguage(String _languageName, String _nativeName, String _code, FontFamily _font) {
        this.languageName = _languageName;
        this.nativeName = _nativeName;
        this.code = _code;
        this.font = _font;
    }

    // Getters for object's attributes.
    public String getLanguageName() {
        return languageName;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getCode() {
        return code;
    }

    public FontFamily getFont() {
        return font;
    }

    @Override
    public String toString() {
        return "JsonLanguage{" + "languageName=" + languageName + ", nativeName=" + nativeName + ", code=" + code + ", font=" + font + '}';
    }

}