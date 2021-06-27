package com.flat.models.json.language;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLanguage {
    private final String languageName;
    private final String nativeName;
    private final String code;

    public JsonLanguage(String _languageName, String _nativeName, String _code) {
        this.languageName = _languageName;
        this.nativeName = _nativeName;
        this.code = _code;
    }

}