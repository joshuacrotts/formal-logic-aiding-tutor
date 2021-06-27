package com.flat.models.json.language;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLanguage {
    private String languageName;
    private String nativeName;
    private String code;

    public JsonLanguage (String _languageName, String _nativeName, String _code) {
        this.languageName = _languageName;
        this.nativeName = _nativeName;
        this.code = _code;
    }

}