package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://stackoverflow.com/questions/5785745/make-copy-of-array
// https://www.google.fi/search?q=minimum+swaps+to+sort+array+in+ascending+order&oq=minimum+swaps+in+array&aqs=chrome.3.69i57j69i60l2j0.24191j0j7&sourceid=chrome&ie=UTF-8
public class MinimumSwaps5 {

    static int minimumSwaps(int[] arr) {

        int minValue = 0, targetIndex = 0, swaps = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == getMinValue(arr, i)) {
//                System.out.println("no swaps round: " + i);
//                System.out.println("min: " + getMinValue(arr, i));
            } else {
//                System.out.println("swaps at round: " + i);
                minValue = getMinValue(arr, i);
                targetIndex = findIndex(arr, minValue);
//                System.out.println("minValue: " + minValue + " index: " + targetIndex);
                swap(arr, i, targetIndex);
                swaps++;
            }
        }

        System.out.println("");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        System.out.println("swaps: " + swaps);
        return swaps;
    }

    private static void swap(int[] arr, int begin, int end) {
//        System.out.println("\n-------in swap 1 -----------");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("");
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("\n------- in swap ------------");
    }

    private static int getMinValue(int[] numbers, int min) {
//        System.out.println("\n------- min --------------");
//        for (int i = min; i < numbers.length; i++) {
//            System.out.print(numbers[i] + " ");
//        }
//        System.out.println("\n-------- min -------------");
        int minValue = numbers[min];
        for (int i = 1 + min; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
//        System.out.println("min: " + minValue);
        return minValue;
    }

    private static int findIndex(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int[] generateRandomArray(int n) {
        System.out.println("creating a random list with size of: " + n);
        int[] arr = new int[n];
        Random random = new Random();
//        arr[0] = n;
//        arr[1] = "\n";
        for (int i = 0; i < n; i++) {
            int number = random.nextInt(100000);
            arr[i] = number;
        }

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);

        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String FNAME = "c:\\temp\\minimumSwaps.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FNAME));

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        
//        
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
        System.out.print("Give the length of array: ");
        int arrayLenght = Integer.parseInt(scanner.nextLine());

        int[] arr = generateRandomArray(arrayLenght);

        System.out.println("--------------------------------");

//        for (int i = 0; i < arrItems.length; i++) {
//            System.out.print(arrItems[i] + " ");
//
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//
//        }

        System.out.println("--------------------------------");

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}