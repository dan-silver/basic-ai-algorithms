package com.company;

import java.util.ArrayList;

public class Main {
    //command line execution [program name] [points file path] [cost file path]
    public static void main(String[] args) {
        PointsFileReader pointsReader = new PointsFileReader(args[0]);
        ArrayList<Point> points = pointsReader.getPoints();
        int numberOfPoints = points.size();

        CostFileReader c = new CostFileReader(args[1], numberOfPoints);
        Integer costs[][] = c.getCosts();



    }
}


