package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
public class ArrayManipulation3 {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long arr[] = new long[n];

        System.out.println("rows: " + queries.length);
        System.out.println("columns: " + n);

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];

            arr[a] += k;
            if (b + 1 < n) {
                arr[b + 1] -= k;
            }
        }

        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(arr[i], max);
        }
        return max;
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
