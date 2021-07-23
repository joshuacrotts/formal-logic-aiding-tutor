package com.flat.models.data.algorithms.general.closedtreedeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class ClosedTreeDeterminer extends Algorithm {

    public ClosedTreeDeterminer () {
        super(new KeyedText(ClosedTreeDeterminer.class, Algorithm.Keys.LABEL, "Closed Tree Determiner"),
                AlgorithmType.CLOSED_TREE_DETERMINER
        );
    }

    public ClosedTreeDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}