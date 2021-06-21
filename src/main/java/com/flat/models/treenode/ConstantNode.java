package com.flat.models.treenode;

import com.flat.algorithms.TexPrinter;

/**
 *
 */
public class ConstantNode extends WffTree {

    public ConstantNode(String _symbol) {
        super(_symbol, NodeType.CONSTANT);
    }

    @Override
    public WffTree copy() {
        ConstantNode constantNode = new ConstantNode(this.getSymbol());
        constantNode.setFlags(this.getFlags());
        return constantNode;
    }

    @Override
    public String getStringRep() {
        return this.getSymbol();
    }

    @Override
    public String getTexCommand() {
        return TexPrinter.removeMathMode(this.getSymbol());
    }

    @Override
    public String getTexParseCommand() {
        return this.getTexCommand();
    }

    @Override
    public String toString() {
        return super.toString() + ": " + super.getSymbol();
    }
}
