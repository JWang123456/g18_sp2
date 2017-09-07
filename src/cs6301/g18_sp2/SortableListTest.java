package cs6301.g18_sp2;

public class SortableListTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		SortableList<Integer> list = new SortableList<>();
		Integer i = 7;
		while(i > 0) {
			list.add(new Integer(i));
			i = i - 1;
		}
		list.printList();
		SortableList.mergeSort(list);
	}
}
