package edu.handong.csee.java.example.fileread.benchmark;

/**
 * Created by sherxon on 4/23/17. https://github.com/sherxon/AlgoDS/tree/master/src/oi
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* This is usage of simple Scanner class with timer.
* */
public class UsingScanner {

    public static void main(String[] args) throws IOException {

        //-------------- Test reading 1 MB file. --------------------
        StopWatch.start();

        Scanner scanner = new Scanner(new File(DumpDataWriter.input1MB));
        while (scanner.hasNext()) scanner.next();

        long duration = StopWatch.stop();
        System.out.println(duration + " milsec");
        
        scanner.close();

        //-------------- Test reading 10 MB file. --------------------
        StopWatch.start();

        Scanner scanner2 = new Scanner(new File(DumpDataWriter.input10MB));
        while (scanner2.hasNext()) scanner2.next();

        long duration2 = StopWatch.stop();
        System.out.println(duration2 + " milsec");
        
        scanner2.close();

        /*
        //-------------- Test reading 100 MB file. --------------------
        StopWatch.start();

        Scanner scanner3 = new Scanner(new File(DumpDataWriter.input100MB));
        while (scanner3.hasNext()) scanner3.next();

        long duration3 = StopWatch.stop();
        System.out.println(duration3 + " milsec");
        
        scanner3.close();

        //-------------- Test reading 1000 MB file. --------------------
        StopWatch.start();

        Scanner scanner4 = new Scanner(new File(DumpDataWriter.input1000MB));
        while (scanner4.hasNext()) scanner4.next();

        long duration4 = StopWatch.stop();
        System.out.println(duration4 + " milsec");
        
        scanner4.close();
        */
    }
}
