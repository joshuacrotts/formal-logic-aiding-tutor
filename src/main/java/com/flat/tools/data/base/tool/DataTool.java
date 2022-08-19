package com.flat.tools.data.base.tool;

import com.flat.tools.data.json.JsonTools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christopherbrantley
 */
public abstract class DataTool {
    public static final Charset ENCODING = StandardCharsets.UTF_8;

    public DataTool () {
    }

    public static void handleDirectory(Path _path) {
        File file = new File(_path.toString());
        if (!file.isDirectory())
            file.mkdir();
    }

    public static void handleFile(Path _path) {
        File file = new File(_path.toString());
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(JsonTools.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}