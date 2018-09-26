package hacker_warmup;

import java.util.*;
import java.io.*;

class JavaLoops2 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listSums = new ArrayList<Integer>();
        int t = in.nextInt();
        System.out.println("");
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            list.add(a);
            list.add(b);
            list.add(n);

        }
        in.close();

        for (int i = 0, k = 0; i < t; i++) {

            for (int j = 0, countedNumber = 0, sum = list.get(i + k), b = list.get(i + (k + 1)); j < list.get(i + (k + 2)); j++) {
                countedNumber = (int) Math.pow(2, j) * b;
                sum += countedNumber;
                listSums.add(sum);
            }
            k += 2;
            for (Integer num : listSums) {
                System.out.print(num + " ");
            }
            listSums.clear();
            System.out.println("");
        }
    }
}
