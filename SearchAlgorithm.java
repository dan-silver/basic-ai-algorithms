package com.company;

import java.util.ArrayList;

/**
 * Created by dan on 9/15/15.
 */
public abstract class SearchAlgorithm {
    abstract public Node searchMain(int i, int i1, ArrayList<Integer> orderOfExpansion);
    enum searchResultStatus {SOLUTION, FAILURE, CUTOFF}
    String algorithmName;

    class SearchResultHelper {
        searchResultStatus status;
        Node resultNode;
        SearchResultHelper(searchResultStatus status) {
            this.status = status;
        }

        public SearchResultHelper(Node node, searchResultStatus solution) {
            this.resultNode = node;
            this.status = solution;
        }
    }

    boolean goalTest(int problem, Node node) {
        return node.index == problem;
    }
}
