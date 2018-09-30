package hacker_warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.objects.NativeArray.map;

// https://stackoverflow.com/questions/5785745/make-copy-of-array
// https://www.google.fi/search?q=minimum+swaps+to+sort+array+in+ascending+order&oq=minimum+swaps+in+array&aqs=chrome.3.69i57j69i60l2j0.24191j0j7&sourceid=chrome&ie=UTF-8
//https://www.mkyong.com/java/how-do-convert-array-to-list-in-java/
//https://stackoverflow.com/questions/157944/create-arraylist-from-array
public class MinimumSwaps_working {

    static int minimumSwaps(int[] arr) {
        int arrLen = arr.length;
        int count = 0;
        int[] sarr = arr.clone();
        Arrays.sort(sarr);

        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != sarr[i]) {
                count++;
                for (int j = i + 1; j < arrLen; j++) {
                    if (arr[j] == sarr[i]) {
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
            }
        }
        return count;
        // secs: 0.013660817
    }
    
    private static int minimumSwapsb(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; /*i++*/) {
            if (arr[i] == (i + 1) || arr[i] >= arr.length) {
                i++;
                continue;
            }

            int tmp = arr[i];
            arr[i] = arr[tmp - 1];
            arr[tmp - 1] = tmp;

            count++;
        }

        return count;
        // secs: 0.002736805
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
