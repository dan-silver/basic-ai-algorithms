package com.company;

import java.util.ArrayList;

/**
 * Created by dan on 9/15/15.
 */
public class IterativeDeepeningSearch extends SearchAlgorithm{
        Integer[][] costs;
        IterativeDeepeningSearch(Integer[][] costs) {
            this.costs = costs;
            this.algorithmName = "Iterative Deepening Search";
        }

        private int stepCost(Node from, int problem, Node to) {
            return costs[from.index][to.index];
        }

        public Node searchMain(int startingIndex, int problem, ArrayList<Integer> orderOfExpansion) {
            int depth = 0;

            Node startingNode = new Node();
            startingNode.index = startingIndex;

            while (true) {

                SearchResultHelper result = depthLimitedSearch(startingNode, problem, depth, orderOfExpansion);

                if (result.status != searchResultStatus.CUTOFF) {
                    return result.resultNode;
                }

                depth += 1;
            }
        }

    private SearchResultHelper depthLimitedSearch(Node startingNode, int problem, int limit, ArrayList<Integer> orderOfExpanion) {
        return recursiveDLS(startingNode, problem, limit, orderOfExpanion);
    }

    private SearchResultHelper recursiveDLS(Node node, int problem, int limit, ArrayList<Integer> orderOfExpansion) {
        boolean cutoffOccurred = false;

        if (goalTest(problem, node)) {
            return new SearchResultHelper(node, searchResultStatus.SOLUTION);
        } else if (node.depth == limit) {
            return new SearchResultHelper(searchResultStatus.CUTOFF);
        } else {
            // for each successor in expand(node, problem)
            orderOfExpansion.add(node.index);
            for (Node successor : expand(node, problem)) {
                SearchResultHelper result = recursiveDLS(successor, problem, limit, orderOfExpansion);
                if (result.status == searchResultStatus.CUTOFF) {
                    cutoffOccurred = true;
                } else if (result.status != searchResultStatus.FAILURE) {
                    return result;
                }
            }
        }
        if (cutoffOccurred) {
            return new SearchResultHelper(searchResultStatus.CUTOFF);
        } else {
            return new SearchResultHelper(searchResultStatus.FAILURE);
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