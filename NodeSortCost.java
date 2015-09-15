package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dan on 9/14/15.
 */
public class NodeSortCost implements Comparator<Node> {

    @Override
    public int compare(Node n1, Node n2) {
        //during a search if there's a tie, lower id has higher priority
        if (n1.pathCost == n2.pathCost) {
            return n1.index - n2.index;
        }

        return n1.pathCost - n2.pathCost;
    }

    // By default, lower path costs have higher priority
    public static boolean testLowestCostReturnedFirst() {
        NodeSortCost sorter = new NodeSortCost();
        PriorityQueue<Node> fringe = new PriorityQueue<>(2, sorter);

        //create 2 nodes with different path costs
        Node n1 = new Node();
        n1.pathCost = 500;

        Node n2 = new Node();
        n2.pathCost = 100;

        fringe.add(n1);
        fringe.add(n2);

        Node highestPriority = fringe.poll();
        return highestPriority == n2; //true = test passed, false = test failed
    }

    // When the path costs are equal, lower ids have higher priority
    public static boolean testCompareEqualCosts() {
        NodeSortCost sorter = new NodeSortCost();
        PriorityQueue<Node> fringe = new PriorityQueue<>(2, sorter);

        //create 2 nodes with equal path costs
        Node n1 = new Node();
        n1.pathCost = 2;
        n1.index = 5;

        Node n2 = new Node();
        n2.pathCost = 2;
        n2.index = 10;

        fringe.add(n1);
        fringe.add(n2);

        Node highestPriority = fringe.poll();
        return highestPriority == n1; //true = test passed, false = test failed
    }
}