package com.flat.view.tools;

import java.io.File;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ResourceManager {
    public static String RESOURCEPATH = "src/main/resources/assets/stylesheets/";

    public static String getDefaultStyle () {
        return "file:///" + ResourceManager.cleanPath(new File(ResourceManager.RESOURCEPATH + "style.css").getAbsolutePath());
    }

    private static String cleanPath (String _path) {
        return _path.replace("\\", "/").replaceAll("\\u0020", "%20");
    }

}