package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.items.export.JsonLatexParseTreeMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTableMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTreeMenuItem;
import com.flat.models.translation.Translatable;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonExportAsPdfMenu extends Translatable {
    @Expose
    private JsonString exportAsPdf = new JsonString("Export as Pdf(.pdf)");
    @Expose
    private JsonLatexParseTreeMenuItem latexParseTreeMenuItem = new JsonLatexParseTreeMenuItem();
    @Expose
    private JsonLatexTruthTreeMenuItem latexTruthTreeMenuItem = new JsonLatexTruthTreeMenuItem();
    @Expose
    private JsonLatexTruthTableMenuItem latexTruthTableMenuItem = new JsonLatexTruthTableMenuItem();

    public JsonString getExportAsPdf() {
        return exportAsPdf;
    }

    public JsonLatexParseTreeMenuItem getLatexParseTreeMenuItem() {
        return latexParseTreeMenuItem;
    }

    public JsonLatexTruthTreeMenuItem getLatexTruthTreeMenuItem() {
        return latexTruthTreeMenuItem;
    }

    public JsonLatexTruthTableMenuItem getLatexTruthTableMenuItem() {
        return latexTruthTableMenuItem;
    }

    public void setExportAsPdf(JsonString exportAsPdf) {
        this.exportAsPdf = exportAsPdf;
    }

    public void setLatexParseTreeMenuItem(JsonLatexParseTreeMenuItem latexParseTreeMenuItem) {
        this.latexParseTreeMenuItem = latexParseTreeMenuItem;
    }

    public void setLatexTruthTreeMenuItem(JsonLatexTruthTreeMenuItem latexTruthTreeMenuItem) {
        this.latexTruthTreeMenuItem = latexTruthTreeMenuItem;
    }

    public void setLatexTruthTableMenuItem(JsonLatexTruthTableMenuItem latexTruthTableMenuItem) {
        this.latexTruthTableMenuItem = latexTruthTableMenuItem;
    }

    @Override
    public LinkedList<JsonString> toTranslate() {
        return new LinkedList<JsonString>(){{
            add(exportAsPdf);
            addAll(latexParseTreeMenuItem.toTranslate());
            addAll(latexTruthTreeMenuItem.toTranslate());
            addAll(latexTruthTableMenuItem.toTranslate());
        }};
    }

}