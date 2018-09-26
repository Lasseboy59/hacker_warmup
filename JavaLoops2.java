package hacker_warmup;

import java.util.*;
import java.io.*;

class JavaLoops2 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int t = in.nextInt();
        System.out.println("");
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            System.out.print(a + " ");
            System.out.print("");
            System.out.print(b + " ");
            System.out.print("");
            System.out.print(n + " ");
            System.out.println("");

            list.add(a);
            list.add(b);
            list.add(n);

        }
        in.close();

        int firstNum = 0, countedNumber = 0;
        int b = list.get(1);
//        System.out.println("size: " + list.size());
//        System.out.println("how many: " + list.get(2));
//        System.out.println("b : " + b);
        firstNum = list.get(0);
        

        for (int j = 0, sum = list.get(0); j < list.get(2); j++) {
           
//            System.out.println(j + " list: ");
//            System.out.println("counted number = " + b + " ^ " + j);
            countedNumber = (int) Math.pow(b, j)* b;

//            System.out.println("countedNumber: " + countedNumber);
            sum += countedNumber;
            System.out.println(sum + " ");

        }
        System.out.println("");

    }
}
