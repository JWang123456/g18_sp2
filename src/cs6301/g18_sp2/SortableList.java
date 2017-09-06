package cs6301.g18_sp2;

public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
	
	SortableList<T> list;
	
	public SortableList(Entry<T> head, Entry<T> tail) {
		super();
		list.head = head;
		list.tail = tail;
	}
	
    void merge(SortableList<T> otherList) {  // Merge this list with other list
    	Entry<T> head1 = list.head;
    	Entry<T> tail1 = list.tail;
		Entry<T> head2 = otherList.head;
		Entry<T> tail2 = otherList.head;
		Entry<T> head = new Entry<T>(null, null);
		Entry<T> cur = head;
		Entry<T> cur1 = head1;
		Entry<T> cur2 = head2;
		while(cur1 != tail1 || cur2 != tail2) {
			if(cur1.element.compareTo(cur2.element) < 0) {
				cur.next = cur1;
				cur1 = cur1.next != tail1 ? cur1.next : cur2.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next != tail2 ? cur2.next : cur1.next;
			}
			cur = cur.next;
		}
    }
    
    void mergeSort() { // Sort this list
    	if(list.head == list.tail) {
    		return;
    	}
    	mergeSort(list);
    }
    
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> list) {
    	Entry<T> tail1 = new Entry<T>(null, null);
		tail1.next = list.head;
		Entry<T> head1 = list.head;
		Entry<T> head2 = list.head;
		Entry<T> tail2 = list.head;
		while (tail2.next != null) {
			tail1 = tail1.next;
			head2 = head2.next;
			tail2 = tail2.next.next;
		}
		SortableList<T> list1 = new SortableList<T>(head1, tail1);
		SortableList<T> list2 = new SortableList<T>(head2, tail2);
		list1.mergeSort();
		list2.mergeSort();
		list1.merge(list2);
    }
    
}
