package com.company;

import java.util.ArrayList;

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

        int startingIndex = 10;
        int targetIndex = 19;

        // UNIFORM COST TREE SEARCH
        AlgorithmRunner.execute(new UniformCostTreeSearch(costs), startingIndex, targetIndex);

        // ITERATIVE DEEPENING SEARCH
        AlgorithmRunner.execute(new IterativeDeepeningSearch(costs), startingIndex, targetIndex);
    }
}