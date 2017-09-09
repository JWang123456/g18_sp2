package cs6301.g18;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSetsTest {

	public static <T> void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			list1.add(i + 1);
		}
		for(int i = 2; i < 6; i++) {
			list2.add(i + 1);
		}
		System.out.println("list1: " + list1.toString());
		System.out.println("list1: " + list2.toString());
		List<Integer> outList = new ArrayList<>();
		LinkedListSets.intersect(list1, list2, outList);
		System.out.println("Intersection: " + outList.toString());
		outList.clear();
		LinkedListSets.union(list1, list2, outList);
		System.out.println("Union: " + outList.toString());
		outList.clear();
		LinkedListSets.difference(list1, list2, outList);
		System.out.println("Difference: " + outList.toString());
	}
}
