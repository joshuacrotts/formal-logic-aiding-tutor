package com.flat.tools.data.serial;

import com.flat.models.json.language.JsonLanguage;
import com.flat.tools.data.base.tool.DataTool;
import com.flat.tools.data.base.enums.LocalData;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author christopherbrantley
 */
public class SerialTools extends DataTool {

    public static <T> void serializeObject (JsonLanguage _language, LocalData.File _file, T _object, Class <T> _class) {
        Path path = Paths.get(LocalData.Paths.SERIAL_ROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        DataTool.handleDirectory(path.getParent());
        DataTool.handleFile(path);
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            writer.writeObject(_object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserializeObject (JsonLanguage _language, LocalData.File _file, Class <T> _class) {
        Path path = Paths.get(LocalData.Paths.SERIAL_ROOT.getFilePath()
                + _language.getCode() + "/"
                + _file.getFileName());
        DataTool.handleDirectory(path.getParent());
        DataTool.handleFile(path);
        try (ObjectInputStream  reader = new ObjectInputStream (new FileInputStream(path.toString()))) {
            return ((T)reader.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}