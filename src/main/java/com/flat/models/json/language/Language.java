package com.flat.models.json.language;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 * Structure for the Json Language object.
 */
public class Language {
    private String languageName;
    private String nativeName;
    private String code;

    public Language (String _languageName, String _nativeName, String _code) {
        this.languageName = _languageName;
        this.nativeName = _nativeName;
        this.code = _code;
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

    // Setters for object's attributes.
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Language{" + "languageName=" + languageName + ", nativeName=" + nativeName + ", code=" + code + '}';
    }

}