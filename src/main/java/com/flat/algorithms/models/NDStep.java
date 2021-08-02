package com.flat.algorithms.models;

/**
 *
 */
public enum NDStep {

    P("Ass.", "Assumption", "Ass.", 0),
    PRAA("Ass. for RAA", "Ass. for RAA", "Ass. for RAA", 0),
    C("C", "Conclusion", "", 0),
    II("→I", "Implication Intro.", "{$\\to$}I", 2),
    MP("MP", "Modus Ponens", "MP", 2),
    MT("MT", "Modus Tollens", "MT", 2),
    AI("&I", "Conjunction Intro.", "{$\\varland$}I", 2),
    AE("&E", "Conjunction Elim.", "{$\\varland$}E", 1),
    OI("∨I", "Disjunction Intro.", "{$\\lor$}I", 1),
    HS("HS", "Hypothetical Syllogism", "HS", 2),
    DS("DS", "Disjunctive Syllogism", "DS", 2),
    BCI("BCI", "Biconditional Intro.", "{$\\varliff$}I", 2),
    BCB("BCB", "Biconditional Breakdown", "{$\\varliff$}E", 1),
    DNI("DNI", "Double Negation Intro.", "DNI", 1),
    DNE("DNE", "Double Negation Elim.", "DNE", 1),
    RI("RAA", "Contradiction", "{$\\bot$}I", 2),
    RE("⊥E", "Contradiction Elim.", "{$\\bot$}E", 1),
    DEM("DeM", "De Morgan", "DeM", 1),
    MI("MI", "Material Implication", "MI", 1),
    TP("TP", "Transposition", "Trans.", 1),
    EI("∃I", "Existential Intro.", "{$\\exists$}I", 1),
    EE("∃E", "Existential Elim.", "{$\\exists$}E", 1),
    UI("UI", "Universal Intro.", "UI", 1),
    UE("UE", "Universal Elim.", "UE", 1),
    CD("CD", "Constructive Dilemma", "CD", 3),
    DD("DD", "Destructive Dilemma", "DD", 3);

    /**
     *
     */
    private final String STEP;

    /**
     *
     */
    private final String TEXT_STEP;

    /**
     *
     */
    private final String TEX_CMD;

    /**
     *
     */
    private final int OP_COUNT;

    NDStep(String _step, String _textStep, String _texCommand, int _opCount) {
        this.STEP = _step;
        this.TEXT_STEP = _textStep;
        this.TEX_CMD = _texCommand;
        this.OP_COUNT = _opCount;
    }

    public String getTextStep() {
        return this.TEXT_STEP;
    }

    public String getTexCommand() {
        return this.TEX_CMD;
    }

    public int getOpCount() { return this.OP_COUNT; }

    @Override
    public String toString() {
        return STEP;
    }
}