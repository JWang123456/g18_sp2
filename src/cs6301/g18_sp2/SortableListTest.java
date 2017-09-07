package cs6301.g18_sp2;

public class SortableListTest {
	public static void main(String[] args) {
		SortableList<Integer> list = new SortableList<>();
		Integer i = 100;
		while(i < 200) {
			list.add((int) (Math.random() * i));
			i = i + 10;
		}
		list.printList();
		SortableList.mergeSort(list);
	}
}
