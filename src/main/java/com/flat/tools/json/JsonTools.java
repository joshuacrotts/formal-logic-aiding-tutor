package com.flat.tools.json;

import com.flat.models.json.language.Language;
import com.flat.tools.json.enums.JsonLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonTools {

    /**
     *
     * @param <T> Fx data objects.
     * @param _language The Language that is in use. The Language code is used
     * in the file path.
     * @param _file The file name where the Json objects are stored.
     * @param _class The class type of the Json object.
     * @return Object of param _class type.
     */
    public static <T> T jsonToObject (Language _language, JsonLocal.File _file, Class<T> _class) {
        Path path = Paths.get(System.getProperty("user.dir")
                + JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8))) {
            T object = new Gson().fromJson(reader, _class);
            return object;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
    public static <T> T[] jsonToObjectList (Language _language, JsonLocal.File _file, Class<T[]> _class) {
        Path path = Paths.get(System.getProperty("user.dir")
                + JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8))) {
            T[] object = new Gson().fromJson(reader, _class);
            return object;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void objectToJson (Language _language, JsonLocal.File _file, T _object, Class<T> _class) {
        Path path = Paths.get(System.getProperty("user.dir")
                + JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path.toString()), StandardCharsets.UTF_8)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.serializeNulls();
            gsonBuilder.setPrettyPrinting();
            gsonBuilder.excludeFieldsWithoutExposeAnnotation();
            writer.write(gsonBuilder.create().toJson(_object, _class));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDirectory (Path _path) {
        File file = new File(_path.toString());
        if (!file.isDirectory())
            file.mkdir();
    }

    private static void handleFile (Path _path) {
        File file = new File(_path.toString());
        if (!file.exists())
            try {
                file.createNewFile();
            }
            catch (IOException ex) {
                Logger.getLogger(JsonTools.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
}