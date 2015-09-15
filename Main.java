package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //command line execution [program name] [points file path] [cost file path]
    public static void main(String[] args) {

        // Test cases (not part of the assignment directly, but ensures that primitive functions are working as expected)
        if (!NodeSortCost.testCompareEqualCosts()) {
            System.out.println("testCompareEqualCosts failed");
            return;
        }
        if (!NodeSortCost.testLowestCostReturnedFirst()) {
            System.out.println("testLowestCostReturnedFirst failed");
            return;
        }



        PointsFileReader pointsReader = new PointsFileReader(args[0]);
        ArrayList<Point> points = pointsReader.getPoints();
        int numberOfPoints = points.size();

        CostFileReader c = new CostFileReader(args[1], numberOfPoints);
        Integer costs[][] = c.getCosts();

        UniformCostTreeSearch uniform = new UniformCostTreeSearch(costs);

        int startingIndex = 1;
        int targetIndex = 5;
        ArrayList<Integer> orderOfExpansion = new ArrayList<>();

        Node result = uniform.treeSearch(startingIndex-1, targetIndex-1, orderOfExpansion);
        System.out.print("Order of expansion: ");
        for (Integer index : orderOfExpansion) {
            System.out.print(index + " ");
        }
        System.out.println();

        System.out.println("Path cost to solution: " + result.pathCost);
        //print the path of the solution

        ArrayList<Node> solutionPath = new ArrayList<>();
        while (result != null) {
            solutionPath.add(result);
            result = result.parent;
        }
        Collections.reverse(solutionPath);


        System.out.print("Route to goal: ");
        for (Node solutionPathNode : solutionPath) {
            System.out.print((solutionPathNode .index + 1) + " ");

        }
        System.out.println();

    }
}