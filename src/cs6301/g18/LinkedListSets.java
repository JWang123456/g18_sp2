package cs6301.g18;

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
		int i = 0;
		int j = 0;
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i).compareTo(l2.get(j)) < 0) {
				i++;
			} else if (l1.get(i).compareTo(l2.get(j)) > 0) {
				j++;
			} else {
				outList.add(l1.get(i));
				i++;
				j++;
			}
		}
	}
	
	public static<T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
	   // Return the union of l1 and l2, in sorted order.
	   // Output is a set, so it should have no duplicates.
		int i = 0;
		int j = 0;
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i).compareTo(l2.get(j)) < 0) {
				outList.add(l1.get(i));
				i++;	
			} else if (l1.get(i).compareTo(l2.get(j)) > 0) {
				outList.add(l2.get(j));
				j++;
			} else {
				outList.add(l1.get(i));
				i++;
				j++;
				
			}
		}
		while(i < l1.size()) {
			outList.add(l1.get(i));
			i++;
		}
		while(j < l2.size()) {
			outList.add(l2.get(j));
			j++;
		}
	}

	public static<T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
	   // Return l1 - l2 (i.e, items in l1 that are not in l2), in sorted order.
	   // Output is a set, so it should have no duplicates.
		int i = 0;
		int j = 0;
		while(i < l1.size() && j < l2.size()) {
			if(l1.get(i).compareTo(l2.get(j)) < 0) {
				outList.add(l1.get(i));
				i++;
			} else if (l1.get(i).compareTo(l2.get(j)) > 0) {
				outList.add(l2.get(j));
				j++;
			} else {
				i++;
				j++;
			}
		}
		while(i < l1.size()) {
			outList.add(l1.get(i));
			i++;
		}
		while(j < l2.size()) {
			outList.add(l2.get(j));
			j++;
		}
	}
	
	
}
