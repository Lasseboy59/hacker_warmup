/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n----------------");
//        https://stackoverflow.com/questions/5785745/make-copy-of-array

        int min = 0;
        int[] dest = new int[arr.length];
        System.arraycopy( arr, 0, dest, 0, arr.length );
        Arrays.sort(dest);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(dest[i] + " ");
            
        }


        System.out.println("");
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String FNAME = "c:\\temp\\minimumSwaps.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FNAME));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
