package com.flat.tools.json;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.json.enums.JsonLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonTools {
    private static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * @param <T>       Fx data objects.
     * @param _language The JsonLanguage that is in use. The JsonLanguage code is used
     *                  in the file path.
     * @param _file     The file name where the Json objects are stored.
     * @param _class    The class type of the Json object.
     * @return Object of param _class type.
     */
    public static <T> T jsonToObject(JsonLanguage _language, JsonLocal.File _file, Class<T> _class) {
        Path path = Paths.get(JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), JsonTools.ENCODING))) {
            T object = new Gson().fromJson(reader, _class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param <T>       List literals.
     * @param _language The JsonLanguage that is in use. The JsonLanguage code is used
     *                  in the file path.
     * @param _file     The file name where the Json objects are stored.
     * @param _class    The class type of the Json object. Note: Must be a
     *                  list literal.
     * @return List of objects of param _class type.
     */
    public static <T> T[] jsonToObjectList(JsonLanguage _language, JsonLocal.File _file, Class<T[]> _class) {
        Path path = Paths.get(JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), JsonTools.ENCODING))) {
            T[] object = new Gson().fromJson(reader, _class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void objectToJson(JsonLanguage _language, JsonLocal.File _file, T _object, Class<T> _class) {
        Path path = Paths.get(JsonLocal.Paths.JSONROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        JsonTools.handleDirectory(path.getParent());
        JsonTools.handleFile(path);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path.toString()), JsonTools.ENCODING)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.serializeNulls();
            gsonBuilder.setPrettyPrinting();
            writer.write(gsonBuilder.create().toJson(_object, _class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDirectory(Path _path) {
        File file = new File(_path.toString());
        if (!file.isDirectory())
            file.mkdir();
    }

    private static void handleFile(Path _path) {
        File file = new File(_path.toString());
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(JsonTools.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}