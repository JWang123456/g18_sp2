package cs6301.g18;

public class SortableListTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		SortableList<Integer> list = new SortableList<>();
		Integer i = 8;
		while(i > 0) {
			list.add(new Integer(i));
			i = i - 1;
		}
//		list.add(133);
//		list.add(6);
//		list.add(159);
//		list.add(83);
//		list.add(100);
		
		System.out.println("The original list is ");
		list.printList();
		System.out.println("After sorting: ");
		SortableList.mergeSort(list);
	}
}
