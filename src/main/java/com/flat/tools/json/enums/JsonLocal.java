package com.flat.tools.json.enums;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonLocal {

    public enum File {
        ALGORITHMS("algorithms"),
        PROPOSITIONAL("propositional"),
        PREDICATE("predicate"),
        MENUBAR("menubar"),
        LANGUAGE("languages");

        private String fileName;

        private File (String _fileName) {
            this.fileName = _fileName;
        }

        // Getters for object's attributes.
        public String getFileName() {
            return fileName + ".json";
        }

    }

    public enum Paths {
        JSONROOT("/src/main/resources/assets/json/");

        private String filePath;

        private Paths (String _filePath) {
            this.filePath = _filePath;
        }

        // Getters for object's attributes.
        public String getFilePath() {
            return filePath;
        }

    }

}