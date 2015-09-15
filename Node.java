package com.company;

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

}
