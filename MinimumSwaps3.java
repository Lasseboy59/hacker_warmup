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

        int minValue = 0, targetIndex = 0, swaps = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == getMinValue(arr, i)) {
            } else {
                minValue = getMinValue(arr, i);
                targetIndex = findIndex(arr, minValue);
                swap(arr, i, targetIndex);
                swaps++;
            }
        }
        return swaps;
    }

    private static void swap(int[] arr, int begin, int end) {
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    private static int getMinValue(int[] numbers, int min) {
        int minValue = numbers[min];
        for (int i = 1 + min; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
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

    private static int[] generateRandomArray(int n) {
        HashSet<Integer> hSet = new HashSet<>();

        int[] arr = new int[n];

        for (int i = 0; hSet.size() < n; i++) {
            int number = (int) (Math.random() * 100010);
            if (number == 0) {
                number += 1;
            }
            hSet.add(number);

        }

        int j = 0;
        for (Integer numInt : hSet) {
            arr[j] = numInt;
            j++;
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String FNAME = "c:\\temp\\minimumSwaps.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FNAME));

        System.out.print("Give the length of array: ");
        int arrayLenght = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[arrayLenght];

        arr = generateRandomArray(arrayLenght);

        System.out.println("--------------------------------");

        long timeLapse = System.nanoTime();

        int res = minimumSwaps(arr);

        timeLapse = System.nanoTime() - timeLapse;
        System.out.println("secs: " + (double) timeLapse / 1000000000);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
