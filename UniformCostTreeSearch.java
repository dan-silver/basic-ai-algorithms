package com.company;

import java.util.*;

/**
 * Created by dan on 9/14/15.
 */
public class UniformCostTreeSearch extends SearchAlgorithm{
    Integer[][] costs;

    UniformCostTreeSearch(Integer[][] costs) {
        this.costs = costs;
        this.algorithmName = "Uniform Cost Tree Search";
    }

    private int stepCost(Node from, int problem, Node to) {
        return costs[from.index][to.index];
    }

    public Node searchMain(int startingIndex, int problem, ArrayList<Integer> orderOfExpansion) {
        ArrayList<Node> explored = new ArrayList<Node>(){}; //starts empty

        NodeSortCost sorter = new NodeSortCost();
        PriorityQueue<Node> fringe = new PriorityQueue<>(20, sorter);

        Node startingNode = new Node();
        startingNode.index = startingIndex;
        startingNode.pathCost = 0;
        fringe.offer(startingNode);
        while (true) {
            if (fringe.size() == 0)
                return null; //indicates FAILURE to find a SOLUTION
            Node node = fringe.poll(); //get the highest priority Node

            if (goalTest(problem, node)) {
                return node;
            }
            explored.add(node);

            orderOfExpansion.add(node.index);
            ArrayList<Node> expandedNodes = expand(node, -1);
            for (Node n : expandedNodes) {
                //add the node to the fringe if it's not already in the fringe or has been explored
                // this part is adapted from page 84 of the textbook
                if (Node.isInListBasedOnIndex(explored, n) == null && Node.isInListBasedOnIndex(fringe, n) == null) {
                    fringe.add(n);
                } else {
                    Node existingNode = Node.isInListBasedOnIndex(fringe, n);
                    if (existingNode == null) continue;
                    if (existingNode.pathCost > n.pathCost) {
                        //replace existing node with n (the current node in the expansion)
                        existingNode.parent = n.parent;
                        existingNode.pathCost = n.pathCost;
                        existingNode.depth = n.depth;
                    }
                }

            }
        }
    }

    private ArrayList<Node> successorFn(Node node) {
        ArrayList<Node> successors = new ArrayList<>();

        //find connected nodes to node
        //iterate through the cost array to find non-null costs
        for (int i=0; i< costs[node.index].length; i++) {
            if (costs[node.index][i] != null) {
                Node n = new Node();
                n.index = i;
                successors.add(n);
            }
        }
        return successors;
    }

    private ArrayList<Node> expand(Node expandingNode, int problem) {
        ArrayList<Node> successors = new ArrayList<>();

        for (Node successor : successorFn(expandingNode)) {
            successor.parent = expandingNode;
            successor.pathCost = expandingNode.pathCost + stepCost(expandingNode, -1, successor);
            successor.depth = expandingNode.depth + 1;

            successors.add(successor);
        }
        return successors;
    }
}