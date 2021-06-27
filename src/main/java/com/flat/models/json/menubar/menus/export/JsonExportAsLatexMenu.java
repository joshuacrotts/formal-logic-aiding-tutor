package com.flat.models.json.menubar.menus.export;

import com.flat.models.json.JsonString;
import com.flat.models.json.menubar.items.export.JsonLatexParseTreeMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTableMenuItem;
import com.flat.models.json.menubar.items.export.JsonLatexTruthTreeMenuItem;
import com.flat.models.translation.Translatable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <ccbrantley@uncg.edu>
 */
public class JsonExportAsLatexMenu extends Translatable {
    private JsonString exportAsLatex = new JsonString("Export as LaTeX(.tex)");
    private JsonLatexParseTreeMenuItem latexParseTreeMenuItem = new JsonLatexParseTreeMenuItem();
    private JsonLatexTruthTreeMenuItem latexTruthTreeMenuItem = new JsonLatexTruthTreeMenuItem();
    private JsonLatexTruthTableMenuItem latexTruthTableMenuItem = new JsonLatexTruthTableMenuItem();

    public JsonString getExportAsLatex() {
        return exportAsLatex;
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

    public void setExportAsLatex(JsonString exportAsLatex) {
        this.exportAsLatex = exportAsLatex;
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
            add(exportAsLatex);
            addAll(latexParseTreeMenuItem.toTranslate());
            addAll(latexTruthTreeMenuItem.toTranslate());
            addAll(latexTruthTableMenuItem.toTranslate());
        }};
    }

}