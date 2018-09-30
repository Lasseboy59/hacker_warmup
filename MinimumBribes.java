package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribes {

    // Complete the minimumBribes function below.
    static void minimumBribesA(int[] q) {
        //if value at (index+1), index starts at zero, minus the index > 2, then it is
        // a chaotic situation
        for (int i = 0; i < q.length; i++) {
            if ((q[i] - (i + 1)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        //now we just need to count number of Swaps
        int swaps = 0;
        for (int i = 0; i < q.length; i++) {
            for (int j = i + 1; j < q.length; j++) {
                if (q[i] > q[j]) {
                    int tmp = q[j];
                    q[j] = q[i];
                    q[i] = tmp;
                    swaps++;
                }
            }
        }

        System.out.println("");
        System.out.println(swaps);

    }

    static void minimumBribesB(int[] q) {
        int count = 0, total = 0;
        boolean flag = true;
        for (int i = 0; i < q.length - 1; i++) {
            for (int j = i + 1; j < q.length; j++) {
                if (q[i] > q[j]) {
                    count++;
                    total = total + 1;
                }
            }
            if (count > 2) {
                flag = false;
                System.out.println("Too chaotic");
                break;
            }
            count = 0;
        }
        System.out.println("");
        if (flag) {
            System.out.println(total);
        }
    }

    static void minimumBribesC(int[] q) {

        int count = 0;

        //always keep track of min three vlaues observed
        //Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree = Integer.MAX_VALUE;
        int minOfThree = Integer.MAX_VALUE;

        //iterating from left to right
        for (int i = q.length - 1; i >= 0; i--) {
            //person has no way to move more than two positions -> wrong
            if ((q[i] - i) > 3) {
                System.out.println("Too chaotic");
                return;
            } else {
                //means current value has passed at least 3 values -> wrong
                if (q[i] > maxOfThree) {
                    System.out.println("Too chaotic");
                    return;
                } else if (q[i] > midOfThree) { //means -> current value has bribed 2 ppl
                    count = count + 2;
                } else if (q[i] > minOfThree) { //means-> current value has bribed 1 person.
                    count = count + 1;
                }

                //Now adjust minThree values comparing, taking the current vlaue to account
                if (q[i] < minOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = minOfThree;
                    minOfThree = q[i];
                } else if (q[i] < midOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = q[i];
                } else if (q[i] < maxOfThree) {
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }

//    https://www.tutorialspoint.com/java/lang/math_max_int.htm
    
    static void minimumBribes(int[] q) {
        int count = 0;
        boolean isChaotic = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                isChaotic = true;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    count++;
                }
            }
        }
        if (isChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(count);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
