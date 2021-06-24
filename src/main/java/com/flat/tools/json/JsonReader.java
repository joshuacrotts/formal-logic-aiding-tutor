package com.flat.tools.json;

import com.flat.models.json.language.Language;
import com.flat.tools.json.enums.JsonLocal;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonReader {

    /**
     * 
     * @param <T> List literals.
     * @param _language The Language that is in use. The Language code is used
     * in the file path.
     * @param _file The file name where the Json objects are stored.
     * @param _class The class type of the Json object. Note: Must be a
     * list literal.
     * @return List of objects of param _class type.
     */
    public static <T> T[] jsonToObject(Language _language, JsonLocal.File _file, Class<T[]> _class) {
        Path path = Paths.get(System.getProperty("user.dir")
                + JsonLocal.Paths.ROOT.getFilePath()
                + _language.getCode() + "\\"
                + _file.getFileName());
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8))) {
            T[] object = new Gson().fromJson(reader, _class);
            return object;
        }
        catch (Exception e) {
            return null;
        }
    }

}