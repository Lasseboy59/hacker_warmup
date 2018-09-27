/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacker_warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

//https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java
public class WriteToFile {

    public static void main(String[] args) throws IOException {

//        int[] x = new int[]{1, 2, 3, 4, 5};
        int[] y = generateRandomArray(100);

        String filename = "c:\\temp\\filewriter_test.log";
        write(filename, y);

    }

    public static void write(String filename, int[] x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(100 + "\n");
        for (int i = 0; i < x.length; i++) {
            outputWriter.write(x[i] + " ");

//            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    static int[] generateRandomArray(int n) {
        System.out.println("creating a random list with size of: " + n);
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int number = random.nextInt(100000);
            arr[i] = number;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        return arr;
    }

}
