
package hacker_warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToList {

	public static void main(String[] argv) {

		String sArray[] = new String[] { "A", "B", "C" };

		// convert array to list #1
		List<String> list = Arrays.asList(sArray);

		System.out.println("list1: " + list);

		// convert array to list #2
		List<String> list2 = new ArrayList<String>(Arrays.asList(sArray));

		System.out.println(list2);

		int iArray[] = new int[] { 1, 2, 3 };

		// Java 8, convert array to List, primitive int[] to List<Integer>
		List<Integer> list3 = Arrays.stream(iArray).boxed().collect(Collectors.toList());

		System.out.println(list3);
	}

}