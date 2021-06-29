package com.flat.algorithms.predicate;

import com.flat.models.treenode.QuantifierNode;
import com.flat.models.treenode.VariableNode;
import com.flat.models.treenode.WffTree;

import java.util.ArrayList;
import java.util.Stack;

public class VacuousQuantifierDetector {

    /**
     *
     */
    private final WffTree wffTree;

    public VacuousQuantifierDetector(WffTree _wffTree) {
        this.wffTree = _wffTree;
    }

    /**
     * @return
     */
    public ArrayList<WffTree> getVacuousQuantifiers() {
        ArrayList<WffTree> VQ = new ArrayList<>();
        Stack<QuantifierNode> S = new Stack<>();
        this.getVacuousQuantifiersHelper(this.wffTree, VQ, S);
        return VQ;
    }

    /**
     * @param _tree
     * @param _vacuousQuantifiers
     * @param _stack
     */
    private void getVacuousQuantifiersHelper(WffTree _tree, ArrayList<WffTree> _vacuousQuantifiers,
                                             Stack<QuantifierNode> _stack) {
        if (_tree.isQuantifier()) {
            _stack.push((QuantifierNode) _tree);
        } else if (_tree.isVariable()) {
            for (QuantifierNode quantifierNode : _stack) {
                if (quantifierNode.getVariableSymbol().equals(_tree.getSymbol())) {
                    quantifierNode.setVacuous(false);
                    return;
                }
            }
        }

        for (WffTree child : _tree.getChildren()) {
            this.getVacuousQuantifiersHelper(child, _vacuousQuantifiers, _stack);
        }

        if (_tree.isQuantifier()) {
            QuantifierNode poppedQuantifier = _stack.pop();
            if (poppedQuantifier.isVacuous()) {
                _vacuousQuantifiers.add(poppedQuantifier);
            }
        }
    }

    public WffTree getWffTree() {
        return this.wffTree;
    }
}
