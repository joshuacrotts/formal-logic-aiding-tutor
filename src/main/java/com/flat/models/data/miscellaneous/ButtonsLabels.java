package com.flat.models.data.miscellaneous;

import com.flat.models.data.base.text.KeyedText;
import com.flat.models.data.base.text.key.KeyBase;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ButtonsLabels extends Translatable implements Serializable {

    public enum Keys implements KeyBase {
        PRACTICE_MODE_ON,
        PRACTICE_MODE_OFF,
        RULES_AXIOMS,
        PRACTICE,
        SOLVE,
        APPLY,
        TRUTH_TREE,
        PARSE_TREE,
        TRUTH_TABLE,
        NATURAL_DEDUCTION,
        RESULT,
    }

    private KeyedText practiceOn = new KeyedText(ButtonsLabels.class, Keys.PRACTICE_MODE_ON, "Practice Mode: ON");
    private KeyedText practiceOff = new KeyedText(ButtonsLabels.class, Keys.PRACTICE_MODE_OFF, "Practice Mode: OFF");
    private KeyedText rulesAxioms = new KeyedText(ButtonsLabels.class, Keys.RULES_AXIOMS, "Rules/Axioms");
    private KeyedText practice = new KeyedText(ButtonsLabels.class, Keys.PRACTICE, "Practice");
    private KeyedText solve = new KeyedText(ButtonsLabels.class, Keys.SOLVE, "Solve");
    private KeyedText apply = new KeyedText(ButtonsLabels.class, Keys.APPLY, "Apply");
    private KeyedText truthTree = new KeyedText(ButtonsLabels.class, Keys.TRUTH_TREE, "Truth Tree");
    private KeyedText parseTree = new KeyedText(ButtonsLabels.class, Keys.PARSE_TREE, "Parse Tree");
    private KeyedText truthTable = new KeyedText(ButtonsLabels.class, Keys.TRUTH_TABLE, "Truth Table");
    private KeyedText naturalDeduction = new KeyedText(ButtonsLabels.class, Keys.NATURAL_DEDUCTION, "Natural Deduction");
    private KeyedText result = new KeyedText(ButtonsLabels.class, Keys.RESULT, "Result:");

    public ButtonsLabels () {
    }

    // Getters for object's attributes.
    public KeyedText getPracticeOn() {
        return practiceOn;
    }

    public KeyedText getPracticeOff() {
        return practiceOff;
    }

    public KeyedText getRulesAxioms() {
        return rulesAxioms;
    }

    public KeyedText getPractice() {
        return practice;
    }

    public KeyedText getSolve() {
        return solve;
    }

    public KeyedText getApply() {
        return apply;
    }

    public KeyedText getTruthTree() {
        return truthTree;
    }

    public KeyedText getParseTree() {
        return parseTree;
    }

    public KeyedText getTruthTable() {
        return truthTable;
    }

    public KeyedText getNaturalDeduction() {
        return naturalDeduction;
    }

    public KeyedText getResult() {
        return result;
    }

    // Setters for object's attributes.
    public void setPracticeOn(KeyedText practiceOn) {
        this.practiceOn = practiceOn;
    }

    public void setPracticeOff(KeyedText practiceOff) {
        this.practiceOff = practiceOff;
    }

    public void setRulesAxioms(KeyedText rulesAxioms) {
        this.rulesAxioms = rulesAxioms;
    }

    public void setPractice(KeyedText practice) {
        this.practice = practice;
    }

    public void setSolve(KeyedText solve) {
        this.solve = solve;
    }

    public void setApply(KeyedText apply) {
        this.apply = apply;
    }

    public void setTruthTree(KeyedText truthTree) {
        this.truthTree = truthTree;
    }

    public void setParseTree(KeyedText parseTree) {
        this.parseTree = parseTree;
    }

    public void setTruthTable(KeyedText truthTable) {
        this.truthTable = truthTable;
    }

    public void setNaturalDeduction(KeyedText naturalDeduction) {
        this.naturalDeduction = naturalDeduction;
    }

    public void setResult(KeyedText result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ButtonsLabels{" + "practiceOn=" + practiceOn + ", practiceOff=" + practiceOff + ", rulesAxioms=" + rulesAxioms + ", practice=" + practice + ", solve=" + solve + ", apply=" + apply + ", truthTree=" + truthTree + ", parseTree=" + parseTree + ", truthTable=" + truthTable + ", naturalDeduction=" + naturalDeduction + ", result=" + result + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.practiceOn);
            os.writeObject(this.practiceOff);
            os.writeObject(this.rulesAxioms);
            os.writeObject(this.practice);
            os.writeObject(this.solve);
            os.writeObject(this.apply);
            os.writeObject(this.truthTree);
            os.writeObject(this.parseTree);
            os.writeObject(this.truthTable);
            os.writeObject(this.naturalDeduction);
            os.writeObject(this.result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.practiceOn = (KeyedText) is.readObject();
            this.practiceOff = (KeyedText) is.readObject();
            this.rulesAxioms = (KeyedText) is.readObject();
            this.practice = (KeyedText) is.readObject();
            this.solve = (KeyedText) is.readObject();
            this.apply = (KeyedText) is.readObject();
            this.truthTree = (KeyedText) is.readObject();
            this.parseTree = (KeyedText) is.readObject();
            this.truthTable = (KeyedText) is.readObject();
            this.naturalDeduction = (KeyedText) is.readObject();
            this.result = (KeyedText) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList<TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            add(practiceOn);
            add(practiceOff);
            add(rulesAxioms);
            add(practice);
            add(solve);
            add(apply);
            add(truthTree);
            add(parseTree);
            add(truthTable);
            add(naturalDeduction);
            add(result);
        }};
    }

}