package adaptor_pattern2;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Main {
	public static void main (String args[]) {
		String[] intArray = {"1", "2", "3", "4", "5"};
		Vector v = new Vector(Arrays.asList(intArray));
		Iterator iterator = new EnumerationIterator(v.elements());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
