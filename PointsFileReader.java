package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dan on 9/14/15.
 */
public class PointsFileReader extends fileReader {
    private ArrayList<Point> points;

    PointsFileReader(String filename) {
        super(filename);
        points = new ArrayList<>();
        this.processFile();
    }

    @Override
    public void processLine(String line, int lineNumber) {
        Scanner s = new Scanner(line);
        int x = s.nextInt();
        int y = s.nextInt();
        points.add(new Point(x, y));
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
