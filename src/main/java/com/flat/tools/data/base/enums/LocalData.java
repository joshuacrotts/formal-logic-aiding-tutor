package com.flat.tools.data.base.enums;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class LocalData {

    public enum File {
        ALGORITHMS("algorithms"),
        LOGIC_SYMBOLS("logicsymbols"),
        MENU_BAR("menubar"),
        LANGUAGE("languages"),
        SETTINGS("settings");

        private final String fileName;

        private File(String _fileName) {
            this.fileName = _fileName;
        }

        // Getters for object's attributes.
        public String getFileName() {
            return fileName + ".json";
        }

    }

    public enum Paths {
        JSON_ROOT(System.getProperty("user.dir") + "/src/main/resources/assets/json/"),
        SERIAL_ROOT(System.getProperty("user.dir") + "/src/main/resources/assets/serial/");

        private final String filePath;

        private Paths(String _filePath) {
            this.filePath = _filePath;
        }

        // Getters for object's attributes.
        public String getFilePath() {
            return filePath;
        }

    }

}