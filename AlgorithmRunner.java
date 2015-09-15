package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dan on 9/15/15.
 */
// Given an algorithm, a starting node, and a target node
// Run the algorithm and print the results
public class AlgorithmRunner {
    public static void execute(SearchAlgorithm algorithm, int startingIndex, int targetIndex) {
        ArrayList<Integer> orderOfExpansion = new ArrayList<>();

        Node result = algorithm.searchMain(startingIndex - 1, targetIndex - 1, orderOfExpansion);
        int solutionCost = result.pathCost;

        ArrayList<Node> solutionPath = new ArrayList<>();
        while (result != null) {
            solutionPath.add(result);
            result = result.parent;
        }
        Collections.reverse(solutionPath);

        System.out.println("\n\n\n***** " + algorithm.algorithmName + " *****");
        System.out.println("Starting node: " + startingIndex);
        System.out.println("Goal node: " + targetIndex);

        System.out.print("Order of expansion: ");
        for (Integer index : orderOfExpansion) {
            System.out.print((index + 1) + " ");
        }
        System.out.println();

        System.out.println("Path cost to solution: " + solutionCost);
        //print the path of the SOLUTION

        System.out.print("Route to goal: ");
        for (Node solutionPathNode : solutionPath) {
            System.out.print((solutionPathNode.humanReadableIndex()) + " ");

        }
        System.out.println();

    }
}