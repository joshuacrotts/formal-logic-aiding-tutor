package com.flat.tools.font;

import com.flat.tools.font.enums.FontLocal;
import com.flat.tools.font.enums.FontLocal.FontFamily;
import javafx.scene.text.Font;

import java.io.FileInputStream;

import static javafx.scene.layout.Region.USE_PREF_SIZE;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class FontTool {
    private static double fontSize = USE_PREF_SIZE;
    private static Font DEFAULT;
    private static Font AMHARIC;
    private static Font BURMESE;
    private static Font JAVANESE;

    private  FontTool () {
    }

    // Setters for object's attributes.
    public static void setFontSize(double fontSize) {
        FontTool.fontSize = fontSize;
    }

    public static Font getFont(FontFamily _fontFamily) {
        Font font = new Font(FontFamily.DEFAULT.getFamily(), fontSize);;
        try {
            switch (_fontFamily) {
                case AMHARIC:
                    font = Font.loadFont(new FileInputStream(FontLocal.Paths.TTF.getPath() + FontFamily.AMHARIC.getFilePath()), FontTool.fontSize);
                    break;
                case BURMESE:
                    font = Font.loadFont(new FileInputStream(FontLocal.Paths.TTF.getPath() + FontFamily.BURMESE.getFilePath()), FontTool.fontSize);
                    break;
                case JAVANESE:
                    font = Font.loadFont(new FileInputStream(FontLocal.Paths.TTF.getPath() + FontFamily.JAVANESE.getFilePath()), FontTool.fontSize);
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }

}