package com.flat.tools.font.enums;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FontLocal {

    public enum FontFamily {
        DEFAULT("", "Arial"),
        AMHARIC("amharic/NotoSansEthiopic-Regular", "Noto Sans Ethiopic"),
        BURMESE("burmese/NotoSansMyanmar-Regular", "Noto Sans Myanmar"),
        JAVANESE("javanese/NotoSansJavanese-Regular", "Noto Sans Javanese");

        private final String filePath;
        private final String family;

        private FontFamily (String _filePath, String _family) {
            this.filePath = _filePath;
            this.family = _family;
        }

        // Getters for object's attributes.
        public String getFilePath() {
            return filePath + ".ttf";
        }

        public String getFamily() {
            return "\"" + family + "\"";
        }

    }

    public enum Paths {
        TTF("/src/main/resources/assets/font/");

        private final String path;

        private Paths (String _path) {
            this.path = _path;
        }

        // Getters for object's attributes.
        public String getPath() {
            return path;
        }

    }

}