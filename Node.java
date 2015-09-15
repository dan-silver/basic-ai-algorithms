package com.company;

import java.util.AbstractCollection;

/**
 * Created by dan on 9/14/15.
 */
public class Node extends Point {
    public int pathCost;
    public Node parent; // used by algorithms to trace the route from the previous node
    public int depth;

    Node(int x_coordinate, int y_coordinate) {
        super(x_coordinate, y_coordinate);
    }
    Node() {}

    //check if the node is already in the list
    //compare the input node's index to every node in the list
    public static Node isInListBasedOnIndex(AbstractCollection<Node> list, Node n) {
        for (Node listNode : list) {
            if (listNode.index == n.index) //compare based on the indices (same rows in the input file)
                return listNode;
        }
        return null; //node is not in the list
    }

    public int humanReadableIndex() {
        return this.index + 1; //documentation is indexed at 1, algorithm indexed at 0
    }

}
