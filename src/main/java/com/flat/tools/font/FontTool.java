package com.flat.tools.font;

import com.flat.tools.font.enums.FontLocal;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import java.io.FileInputStream;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class FontTool {
    private static FontTool instance = null;
    private final static double FONTSIZE = USE_PREF_SIZE;
    private static Font AMHARIC;
    private static Font BURMESE;
    private static Font JAVANESE;

    private FontTool () {
        try {
            FontTool.AMHARIC = Font.loadFont(new FileInputStream(System.getProperty("user.dir") + FontLocal.Paths.TTF.getPath() + FontFamily.AMHARIC.getFilePath()), FontTool.FONTSIZE);
            FontTool.BURMESE = Font.loadFont(new FileInputStream(System.getProperty("user.dir") + FontLocal.Paths.TTF.getPath() + FontFamily.BURMESE.getFilePath()), FontTool.FONTSIZE);
            FontTool.JAVANESE = Font.loadFont(new FileInputStream(System.getProperty("user.dir") + FontLocal.Paths.TTF.getPath() + FontFamily.JAVANESE.getFilePath()), FontTool.FONTSIZE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FontTool getInstance () {
        if (instance == null) {
            instance = new FontTool();
        }
        return instance;
    }

    public static Font getFont (FontFamily _fontFamily) {
        switch (_fontFamily) {
            case AMHARIC:
                return FontTool.AMHARIC;
            case BURMESE:
                return FontTool.BURMESE;
            case JAVANESE:
                return FontTool.JAVANESE;
            default:
                return new Font(FONTSIZE);
        }
    }

}