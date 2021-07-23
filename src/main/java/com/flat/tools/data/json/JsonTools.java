package com.flat.tools.data.json;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.data.base.tool.DataTool;
import com.flat.tools.data.base.enums.LocalData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonTools extends DataTool {

    /**
     * @param <T>       Fx data objects.
     * @param _language The JsonLanguage that is in use. The JsonLanguage code is used
     *                  in the file path.
     * @param _file     The file name where the Json objects are stored.
     * @param _class    The class type of the Json object.
     * @return Object of param _class type.
     */
    public static <T> T jsonToObject(JsonLanguage _language, LocalData.File _file, Class<T> _class) {
        Path path = Paths.get(LocalData.Paths.JSON_ROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        DataTool.handleDirectory(path.getParent());
        DataTool.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), DataTool.ENCODING))) {
            T object = new Gson().fromJson(reader, _class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void objectToJson(JsonLanguage _language, LocalData.File _file, T _object, Class<T> _class) {
        Path path = Paths.get(LocalData.Paths.JSON_ROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        DataTool.handleDirectory(path.getParent());
        DataTool.handleFile(path);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(path.toString()), DataTool.ENCODING)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.serializeNulls();
            gsonBuilder.setPrettyPrinting();
            writer.write(gsonBuilder.create().toJson(_object, _class));

        } catch (Exception e) {
            e.printStackTrace();
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
    public static <T> T[] jsonToObjectList(JsonLanguage _language, LocalData.File _file, Class<T[]> _class) {
        Path path = Paths.get(LocalData.Paths.JSON_ROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        DataTool.handleDirectory(path.getParent());
        DataTool.handleFile(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()), DataTool.ENCODING))) {
            T[] object = new Gson().fromJson(reader, _class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}