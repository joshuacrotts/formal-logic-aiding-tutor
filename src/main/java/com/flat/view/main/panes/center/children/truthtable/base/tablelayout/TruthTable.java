package com.flat.view.main.panes.center.children.truthtable.base.tablelayout;

import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TruthTable {
    private ArrayList <TableHeader> headers = new ArrayList();

    public TruthTable (WffTree _wffTree) {
        _wffTree.getChildren().forEach(child -> {
            //this.headers.add(new TableHeader(child));
        });
    }

}