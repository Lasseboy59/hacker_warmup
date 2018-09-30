package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        System.out.println("rows: " + queries.length);
        System.out.println("columns: " + n);

        int[] arr = new int[n];
        int[][] myArray = new int[n][queries.length];
        myArray = queries;
        
        int[] writeArray = new int[n];
        

        System.out.println("-----------------------------");

        try {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < myArray.length; j++) {
                    System.out.print(myArray[i][j] + " ");
                    
                    arrayManipulation(writeArray, i, myArray, j);
                }
                System.out.println("");
            }
        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
        }
        
        

        System.out.println("-----------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for (int[] a : queries) {
            for (int i : a) {
                System.out.print(i + " ");
                
            }
            System.out.println("");
        }
        long l = 0;
        return l;
    }

    private static void arrayManipulation(int[] writeArray, int i, int[][] myArray, int j) {
        writeArray[i] = myArray[i][j];
        System.out.println("-->  " + writeArray[i]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String FNAME = "c:\\temp\\arrayManipulation.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FNAME));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
