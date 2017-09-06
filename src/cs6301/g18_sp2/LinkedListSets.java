package cs6301.g18_sp2;

import java.util.Collections;
import java.util.List;

public class LinkedListSets<T>  {

	public static<T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) {
	   // Return elements common to l1 and l2, in sorted order.
	   // outList is an empty list created by the calling
	       // program and passed as a parameter.
	   // Function should be efficient whether the List is
	   // implemented using ArrayList or LinkedList.
	   // Do not use HashSet/Map or TreeSet/Map or other complex
	       // data structures.
		for(T element: l1) {
			if(l2.contains(element)) outList.add(element);
		}
		Collections.sort(outList);
	}
	
	public static<T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
	   // Return the union of l1 and l2, in sorted order.
	   // Output is a set, so it should have no duplicates.
		for(T element: l1) {
			outList.add(element);
		}
		for(T element: l2) {
			if(!outList.contains(element)) outList.add(element);
		}
		Collections.sort(outList);
	}

	public static<T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
	   // Return l1 - l2 (i.e, items in l1 that are not in l2), in sorted order.
	   // Output is a set, so it should have no duplicates.
		for(T element: l1) {
			if(!l2.contains(element)) outList.add(element);
		}
		for(T element: l2) {
			if(!l1.contains(element)) outList.add(element);
		}
		Collections.sort(outList);
	}
	
	
}
