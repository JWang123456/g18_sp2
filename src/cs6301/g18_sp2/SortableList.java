package cs6301.g18_sp2;

public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
	
	public SortableList() {
		super();
	}
	
	public SortableList(Entry<T> head, Entry<T> tail) {
		super.head = head;
		super.tail = tail;
	}
	
    void merge(SortableList<T> otherList) {  // Merge this list with other list
    	Entry<T> head1 = this.head;
    	Entry<T> tail1 = this.tail;
		Entry<T> head2 = otherList.head;
		Entry<T> tail2 = otherList.tail;
		Entry<T> cur = new Entry<T>(null, null);
		this.head = cur;
		Entry<T> cur1 = head1.next;
		Entry<T> cur2 = head2.next;
		while(cur != null && cur1 != null && cur2 != null && cur1.element != null && cur2.element != null && cur1 != tail1 && cur2 != tail2) {
			if(cur1.element.compareTo(cur2.element) < 0) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
			//System.out.println(cur.element.toString());
		}
		while(cur1 != null && tail1 != null && cur1 != tail1.next) {
			cur.next = cur1;
			cur1 = cur1.next;
			cur = cur.next;
			//System.out.println(cur.element.toString());
		}
		while(cur2 != null && tail2 != null && cur2 != tail2.next) {
			cur.next = cur2;
			cur2 = cur2.next;
			cur = cur.next;
			//System.out.println(cur.element.toString());
		}

    }
    
    void mergeSort() { // Sort this list
    	if(this.tail == null) return;
    	if(this.head.next.next == this.tail) {
    		if(this.head.next.element.compareTo(this.tail.element) > 0) {
    			this.head.next = new Entry<T>(this.tail.element, this.head.next);
    		} else {
    			this.head.next = new Entry<T>(this.head.next.element, this.tail);
    		}
    		return;
    	}
     	mergeSort(this);
    }
    
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> list) {
    	Entry<T> head1 = list.head;
    	Entry<T> tail1 = list.head;
    	Entry<T> tail2 = list.head;
    	while(tail2 != null && tail2.next != null) {
    		tail1 = tail1.next;
    		tail2 = tail2.next.next;
    	}
    	Entry<T> head2 = new Entry<T>(null, null);
    	head2.next = tail1.next;
    	tail1.next = null;
		SortableList<T> list1 = new SortableList<T>(head1, tail1);
		SortableList<T> list2 = new SortableList<T>(head2, tail2);
		//list1.mergeSort();
		list1.printList();
		//list2.mergeSort();
		list2.printList();
		list1.merge(list2);
		list1.printList();
    }
    
}
