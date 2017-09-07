package cs6301.g18_sp2;

import java.util.Iterator;

public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
	
	static SortableList ans = new SortableList();
	
	public SortableList() {
		super();
	}
	
	public SortableList(Entry<T> head, Entry<T> tail) {
		super.head = head;
		super.tail = tail;
	}
	
    void merge(SortableList<T> otherList) {  // Merge this list with other list
    	if(this == null || otherList == null) return;
    	Iterator itr = otherList.iterator();
    	SortableList<T> temp = new SortableList<T>();
    	while(itr.hasNext()) {
    		temp.add((T)itr.next());
    	}
    	Entry<T> head1 = this.head;
    	Entry<T> tail1 = this.tail;
		Entry<T> head2 = temp.head;
		Entry<T> tail2 = temp.tail;
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
		if(cur2 == tail2 && cur2 != null) {
			cur.next = cur2;
			cur2 = cur2.next;
			cur = cur.next;
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
		return;
    }
    
    void mergeSort() throws CloneNotSupportedException { // Sort this list
    	if(this.tail == null) {
    		//ans.merge(this);
    		return;
    	}
    	if(this.head.next == tail) {
    		ans.merge(this);
    		return;
    	}
    	if(this.head.next.next == this.tail) {
    		if(this.head.next.element.compareTo(this.tail.element) > 0) {
    			T element = this.head.next.element;
    			this.head.next.element = this.tail.element;
    			this.tail.element = element;
    		}
    		ans.merge(this);
    		return;
    	}
    	else {
    		mergeSort(this);
    		//ans.merge(this);
    		return;
    	}
    }
    
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> list) throws CloneNotSupportedException {
    	Iterator itr = list.iterator();
    	SortableList<T> temp = new SortableList<T>();
    	while(itr.hasNext()) {
    		temp.add((T)itr.next());
    	}
    	Entry<T> head1 = temp.head;
    	Entry<T> tail1 = temp.head;
    	Entry<T> tail2 = temp.head;
    	while(tail2 != null && tail2.next != null) {
    		tail1 = tail1.next;
    		tail2 = tail2.next.next;
    	}
    	Entry<T> head2 = new Entry<T>(null, null);
    	head2.next = tail1.next;
    	tail1.next = null;
		SortableList<T> list1 = new SortableList<T>(head1, tail1);
		SortableList<T> list2 = new SortableList<T>(head2, tail2);
		list1.mergeSort();
		list2.mergeSort();
		ans.printList();
		return;
    }
    
}
