package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.base.JsonString;
import com.flat.models.json.base.keyed.KeyedJsonString;
import com.flat.models.json.base.keyed.base.JsonKey;
import com.flat.models.json.menubar.items.export.JsonLatexParseTreeMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTableMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTreeMenuItem;
import com.flat.tools.translation.base.Translatable;

import java.util.LinkedList;

/**
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class JsonExportAsPdfMenu extends Translatable {

    public enum Keys implements JsonKey {
        EXPORT_AS_PDF,
    }

    private KeyedJsonString exportAsPdf = new KeyedJsonString(JsonExportAsPdfMenu.class, Keys.EXPORT_AS_PDF, "Export as Pdf(.pdf)");
    private JsonLatexParseTreeMenuItem latexParseTreeMenuItem = new JsonLatexParseTreeMenuItem();
    private JsonLatexTruthTreeMenuItem latexTruthTreeMenuItem = new JsonLatexTruthTreeMenuItem();
    private JsonLatexTruthTableMenuItem latexTruthTableMenuItem = new JsonLatexTruthTableMenuItem();

    public KeyedJsonString getExportAsPdf() {
        return exportAsPdf;
    }

    public void setExportAsPdf(KeyedJsonString exportAsPdf) {
        this.exportAsPdf = exportAsPdf;
    }

    public JsonLatexParseTreeMenuItem getLatexParseTreeMenuItem() {
        return latexParseTreeMenuItem;
    }

    public void setLatexParseTreeMenuItem(JsonLatexParseTreeMenuItem latexParseTreeMenuItem) {
        this.latexParseTreeMenuItem = latexParseTreeMenuItem;
    }

    public JsonLatexTruthTreeMenuItem getLatexTruthTreeMenuItem() {
        return latexTruthTreeMenuItem;
    }

    public void setLatexTruthTreeMenuItem(JsonLatexTruthTreeMenuItem latexTruthTreeMenuItem) {
        this.latexTruthTreeMenuItem = latexTruthTreeMenuItem;
    }

    public JsonLatexTruthTableMenuItem getLatexTruthTableMenuItem() {
        return latexTruthTableMenuItem;
    }

    public void setLatexTruthTableMenuItem(JsonLatexTruthTableMenuItem latexTruthTableMenuItem) {
        this.latexTruthTableMenuItem = latexTruthTableMenuItem;
    }

    @Override
    public LinkedList <JsonString> toTranslate() {
        return new LinkedList <JsonString>() {{
            add(exportAsPdf);
            addAll(latexParseTreeMenuItem.toTranslate());
            addAll(latexTruthTreeMenuItem.toTranslate());
            addAll(latexTruthTableMenuItem.toTranslate());
        }};
    }

}