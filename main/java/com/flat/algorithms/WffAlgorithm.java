package com.flat.algorithms;

import com.flat.models.treenode.WffTree;

import java.util.ArrayList;

public interface WffAlgorithm {

    ArrayList<WffTree> getList(WffTree tree);

    WffTree get(WffTree tree);
}
