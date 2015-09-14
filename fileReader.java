package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dan on 9/14/15.
 */

public abstract class fileReader {
    String filename;
    fileReader(String filename) {
        this.filename = filename;
    }

    public void processFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line;
        int lineNumber = 0;

        try {
            assert br != null;
            while ((line = br.readLine()) != null) {
                processLine(line, lineNumber);
                lineNumber += 1;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract public void processLine(String line, int lineNumber);
}