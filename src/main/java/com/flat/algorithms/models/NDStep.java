package com.flat.algorithms.models;

/**
 *
 */
public enum NDStep {

    HS("HS", "Hypothetical Syllogism", "HS", 2),
    MT("MT", "Modus Tollens", "MT", 2),
    MP("MP", "Modus Ponens", "MP", 2),
    II("II", "Implication Introduction", "{$\\to$}I", 2),
    P("Ass.", "Assumption", "Ass.", 0),
    PRAA("Ass. for RAA", "Assumption for Reductio Ad Absurdum", "Ass. for RAA", 0),
    C("C", "Conclusion", "", 0),
    DS("DS", "Disjunctive Syllogism", "DS", 2),
    DNI("DNI", "Double Negation Introduction", "DNI", 1),
    DNE("DNE", "Double Negation Elimination", "DNE", 1),
    AE("&E", "Conjunction Elimination", "{$\\varland$}E", 1),
    AI("&I", "Conjunction Introduction", "{$\\varland$}I", 2),
    RI("⊥I", "Contradiction", "{$\\bot$}I", 2),
    RE("⊥E", "Contradiction Elimination", "{$\\bot$}E", 1),
    OI("∨I", "Disjunction Introduction", "{$\\lor$}I", 1),
    DEM("DeM", "De Morgan", "DeM", 1),
    BCI("↔I", "Biconditional Introduction", "{$\\varliff$}I", 2),
    BCE("↔E", "Biconditional Elimination", "{$\\varliff$}E", 1),
    MI("MI", "Material Implication", "MI", 1),
    EI("∃I", "Existential Introduction", "{$\\exists$}I", 1),
    EE("∃E", "Existential Elimination", "{$\\exists$}E", 1),
    UI("UI", "Universal Introduction", "UI", 1),
    UE("UE", "Universal Elimination", "UE", 1),
    CD("CD", "Constructive Dilemma", "CD", 3),
    DD("DD", "Destructive Dilemma", "DD", 3),
    TP("TP", "Transposition", "Trans.", 1);

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