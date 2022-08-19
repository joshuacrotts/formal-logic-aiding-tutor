package com.flat.models.data.algorithms.general.opentreedeterminer;

import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.data.algorithms.base.enums.AlgorithmType;
import com.flat.models.data.base.text.KeyedText;

/**
 *
 * @author christopherbrantley
 */
public class OpenTreeDeterminer extends Algorithm {

    public OpenTreeDeterminer () {
        super(new KeyedText(OpenTreeDeterminer.class, Keys.LABEL, "Open Tree Determiner"),
                AlgorithmType.OPEN_TREE_DETERMINER
        );
    }

    public OpenTreeDeterminer (KeyedText _keyedText, AlgorithmType _type) {
        super(_keyedText, _type);
    }

}