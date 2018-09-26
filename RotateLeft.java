package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RotateLeft {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        System.out.println("rotations: " + d);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        return rotateArray(a, -d);
       
    }

    static int[] rotateArray(int[] data, int n) {
        if (n < 0) // rotating left?
        {
            n = -n % data.length; // convert to +ve number specifying how 
            // many positions left to rotate & mod
            n = data.length - n;  // rotate left by n = rotate right by length - n
        }
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[(i + n) % data.length] = data[i];
        }
        
        System.out.println("");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+ " ");
            
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String FNAME = "c:\\temp\\rotateLeft.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FNAME));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
