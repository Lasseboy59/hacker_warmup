package hacker_warmup;

//https://www.dotnetperls.com/hashset-java
import java.util.HashSet;

public class GetSizeOfJavaHashSetExample {

    public static void main(String[] args) {

        int n = 80;
        int[] arr = new int[n];
        arr = generateRandomArray(n);

        System.out.println("----------------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] generateRandomArray(int n) {
        HashSet<Integer> hSet = new HashSet<>();
        System.out.println("Size of HashSet : " + hSet.size());

        int[] arr = new int[n];

        for (int i = 0; hSet.size() < n; i++) {
            int number = (int) (Math.random() * 1000);
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

//        System.out.println("----------------------------------");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println("\n");
        System.out.println("Size of HashSet after addition : " + hSet.size());

//        for (Integer value : hSet) {
//            System.out.println(value);
//        }
        return arr;
    }
}
