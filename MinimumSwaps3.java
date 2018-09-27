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


public class MinimumSwaps3 {

    static int minimumSwaps(int[] arr) {

        int minValue = 0;
        boolean checked = false;
        int smallest = 0, index = 0, nextNumber = 0, targetIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            minValue = getMinValue(arr, i);
            targetIndex = findIndex(arr, minValue, i);
            System.out.println("round: " + i + " target index: " + targetIndex + " min value: " + minValue);
            if (arr[0] != minValue && !checked) {
                swap(arr, 0, targetIndex);
                checked = true;
            } else if(arr[i] != minValue){
                
            }

        }

        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
        return -1;
    }

    private static void swap(int[] arr, int begin, int end) {
        System.out.println("\n-------in swap 1 -----------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n------- in swap ------------");
    }

    private static void swap(int[] arr, int fromZeroIndex, int smaller, int toSwap) {
        System.out.println("\n-------in swap 1 -----------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n------- in swap 1------------");
        int temp = arr[smaller];
        arr[smaller] = arr[toSwap];
        arr[toSwap] = temp;

        System.out.println("\n-------in swap 2 -----------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n------- in swap 2------------");
    }

    private static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }

    private static int getMinValue(int[] numbers, int min) {
        System.out.println("\n------- min --------------");
        for (int i = min; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n-------- min -------------");
        int minValue = numbers[min];
        for (int i = 1 + min; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        System.out.println("min: " + minValue);
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

    private static int findIndex(int[] a, int target, int counter) {
        System.out.println("\n--- findIndex---- counter: " + counter + " \n-----");
        for (int i = counter; i < a.length; i++) {
            if (a[i] == target) {
                System.out.println("\n--- findIndex---- ret index : " + (i - counter) + " \n-----");
                return i - counter;
            }
        }
        return -1;
    }

    private static int getNextValue(int[] numbers, int biggerThanThis) {
        int maxValue = biggerThanThis;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == (maxValue + 1)) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
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
