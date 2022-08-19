package com.flat.view.main.panes.center.children.solver.trees.base.treelayout.listener.events;

import com.flat.tools.buses.eventbus.components.Event;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class TreeNodeLayoutSet extends Event {

    public TreeNodeLayoutSet () {
        super(Type.TREE_NODE_LAYOUT_SET);
    }

}