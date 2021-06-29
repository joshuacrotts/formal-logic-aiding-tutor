package com.flat.algorithms.models;

import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class NDWffTree {

    /**
     *
     */
    private ArrayList<NDWffTree> derivedParents;

    /**
     *
     */
    private ArrayList<Integer> derivedParentIndices;

    /**
     *
     */
    private WffTree wffTree;

    /**
     *
     */
    private NDStep derivationStep;

    /**
     *
     */
    private int flags;

    private int value;

    public NDWffTree(WffTree _wffTree, int _flags, NDStep _derivationStep, NDWffTree... _derivedParents) {
        this.wffTree = _wffTree;
        this.derivationStep = _derivationStep;
        this.derivedParents = new ArrayList<>();
        this.derivedParentIndices = new ArrayList<>();
        this.flags = _flags;

        if (_derivedParents != null) {
            Collections.addAll(this.derivedParents, _derivedParents);
        }

        this.setTruthTreeValue();
    }

    public NDWffTree(WffTree _wffTree, NDStep _derivationStep, NDWffTree... _derivedParents) {
        this(_wffTree, 0, _derivationStep, _derivedParents);
    }

    public NDWffTree(WffTree _wffTree, NDStep _derivationStep, NDWffTree _derivedParent) {
        this(_wffTree, 0, _derivationStep, _derivedParent);
    }

    public NDWffTree(WffTree _wffTree, NDStep _derivationStep) {
        this(_wffTree, 0, _derivationStep);
    }

    @Override
    public int hashCode() {
        return this.getWffTree().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        NDWffTree otherTree = (NDWffTree) o;
        return this.getWffTree().equals(otherTree.getWffTree())
                || this.getWffTree().stringEquals(otherTree.getWffTree());
    }

    public ArrayList<NDWffTree> getDerivedParents() {
        return this.derivedParents;
    }

    public void setDerivedParents(ArrayList<NDWffTree> _derivedParents) {
        this.derivedParents = _derivedParents;
    }

    public ArrayList<Integer> getDerivedParentIndices() {
        return this.derivedParentIndices;
    }

    public void setDerivedParentIndices(ArrayList<Integer> _derivedParentIndices) {
        this.derivedParentIndices = _derivedParentIndices;
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }

    public void setWffTree(WffTree wffTree) {
        this.wffTree = wffTree;
    }

    public NDStep getDerivationStep() {
        return this.derivationStep;
    }

    public void setDerivationStep(NDStep _derivationStep) {
        this.derivationStep = _derivationStep;
    }

    @Override
    public String toString() {
        if ((this.derivedParents == null || this.derivedParents.isEmpty())
                && (this.derivationStep == NDStep.C || this.derivationStep == NDStep.P)) {
            return String.format("%-50s%-50s", this.wffTree.getStringRep(), this.derivationStep);
        } else {
            // It's a little ugly but it works.
            StringBuilder sb = new StringBuilder(String.format("%-50s", this.wffTree.getStringRep()));
            sb.append(this.derivationStep);
            sb.append(", ");
            for (int i = 0; i < this.derivedParentIndices.size() - 1; i++) {
                sb.append(this.derivedParentIndices.get(i));
                sb.append(", ");
            }
            sb.append(this.derivedParentIndices.get(this.derivedParentIndices.size() - 1));
            return sb.toString();
        }
    }

    public void setFlags(int _flags) {
        this.flags |= _flags;
    }

    public boolean isActive() {
        return (this.flags & NDFlag.ACTIVE) != 0;
    }

    public void setActive(boolean _b) {
        if (_b) {
            this.flags |= NDFlag.ACTIVE;
        } else {
            this.flags &= ~NDFlag.ACTIVE;
        }
    }

    public boolean isHSActive() {
        return (this.flags & NDFlag.HS) != 0;
    }

    public boolean isMPActive() {
        return (this.flags & NDFlag.MP) != 0;
    }

    public boolean isMTActive() {
        return (this.flags & NDFlag.MT) != 0;
    }

    public boolean isDSActive() {
        return (this.flags & NDFlag.DS) != 0;
    }

    public boolean isAndIActive() {
        return (this.flags & NDFlag.AI) != 0;
    }

    public boolean isAndEActive() {
        return (this.flags & NDFlag.AE) != 0;
    }

    public boolean isDEMActive() {
        return (this.flags & NDFlag.DEM) != 0;
    }

    public boolean isBCActive() {
        return (this.flags & NDFlag.BC) != 0;
    }

    public boolean isMIActive() {
        return (this.flags & NDFlag.MI) != 0;
    }

    public boolean isIIActive() {
        return (this.flags & NDFlag.II) != 0;
    }

    public boolean isTPActive() {
        return (this.flags & NDFlag.TP) != 0;
    }

    public boolean isCDActive() {
        return (this.flags & NDFlag.CD) != 0;
    }

    public boolean isDDActive() {
        return (this.flags & NDFlag.DD) != 0;
    }

    public boolean isDNEActive() {
        return (this.flags & NDFlag.DNE) != 0;
    }

    public boolean isDNIActive() {
        return (this.flags & NDFlag.DNI) != 0;
    }

    public boolean isExisActive() {
        return (this.flags & NDFlag.EX) != 0;
    }

    public boolean isUnivActive() {
        return (this.flags & NDFlag.UN) != 0;
    }

    public boolean isAltConclusion() {
        return (this.flags & NDFlag.ALTC) != 0;
    }

    public boolean isSatisfied() {
        return (this.flags & NDFlag.SAT) != 0;
    }

    /**
     * Assigns the precedence value of this truth tree. This is described in
     * further detail in the above javadoc.
     */
    private void setTruthTreeValue() {
        WffTree _node = this.wffTree;
        // This is kind of ugly, I know...
        if (_node.isAtom() || _node.isPredicate()) {
            this.value = 0;
        } else if (_node.isDoubleNegation()) {
            // Double negations have to have a higher priority.
            this.value = 3;
        } else if (_node.isNegation() && !_node.isNegAnd() && !_node.isNegImp() && !_node.isNegOr()) {
            this.value = 4;
        } else if (_node.isExistential()) {
            this.value = 14;
        } else if (_node.isUniversal()) {
            // Universal HAS to be the last operation - if not, then we run the risk of applying it before we
            // have a constant available.
            this.value = 13;
        } else if (_node.isAnd()) {
            this.value = 6;
        } else if (_node.isNegOr() || _node.isNegImp()) {
            this.value = 7;
        } else if (_node.isOr()) {
            this.value = 8;
        } else if (_node.isNegAnd()) {
            this.value = 9;
        } else if (_node.isImp()) {
            this.value = 10;
        } else if (_node.isBicond()) {
            this.value = 11;
        } else {
            this.value = 12;
        }
    }

    public int getValue() {
        return this.value;
    }
}