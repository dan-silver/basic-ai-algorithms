package com.company;

import java.util.Scanner;

/**
 * Created by dan on 9/14/15.
 */
public class CostFileReader extends fileReader {
    private Integer[][] costs;
    private int numberOfPoints;

    CostFileReader(String filename, int numberOfPoints) {
        super(filename);
        this.numberOfPoints = numberOfPoints;
        costs = new Integer[numberOfPoints][numberOfPoints];
        processFile();
    }
    public Integer[][] getCosts() {
        return this.costs;
    }

    @Override
    public void processLine(String line, int lineNumber) {
        Scanner s = new Scanner(line);
        for (int col=0; col<numberOfPoints; col++) {
            Integer cost = s.nextInt();

            // -100 is a null value, which means the points are not connected
            if (cost == -100)
                cost = null;

            costs[lineNumber][col] = cost;
        }
    }
}