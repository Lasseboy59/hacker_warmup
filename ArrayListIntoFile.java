package hacker_warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListIntoFile {

    public static void main(String[] args) {
        final String FNAME = "c:\\temp\\Quora_test.txt";
        ArrayList<String> list_copy = new ArrayList<>();
        int n = 10;
        String[] arr = new String[n];

//        list_copy.add("Line 1");
//        list_copy.add("Line 2");
            arr[1] = "12";
            arr[2] = "25";

        try (BufferedWriter bw
                = new BufferedWriter(new FileWriter(FNAME))) {
//            for (String line : list_copy) {
//                bw.write(line + "\n");
//            }

            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]);
                
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
