
package hacker_warmup;

//https://stackoverflow.com/questions/31128751/how-can-we-rotate-an-array-to-the-left

import java.util.Scanner;

public class RotateLeftStackOverflow {
    private static Scanner sc;

    public static void main(String[] args) {
        int n,k;
        sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        n = sc.nextInt();

        int[] a = new int[n];
        System.out.print("Enter the "+n+" elements in the list: ");
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();

        System.out.print("Enter the number of left shifts to array: ");
        k = sc.nextInt();

        System.out.print("Array before "+k+" shifts: ");
        display(a);

        solution(a,k);
        System.out.println();

        System.out.print("Array after "+k+" shifts: ");
        display(a);
    }

    public static void solution(int[] a, int k){
        int temp=0, j;
        for(int i=0;i<k;i++){
            temp = a[0];
//          j=0;                    // both codes work i.e. for loop and while loop as well
//          while(j<a.length-1){
//              a[j]=a[j+1];
//              j++;
//          }   
            for(j=0;j<a.length-1;j++)
                a[j]=a[j+1];
            a[j]=temp;
        }           
    }

    public static void display(int[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
}