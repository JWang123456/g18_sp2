package cs6301.g18;

import javax.print.attribute.standard.MediaSize.Other;

import cs6301.g00.SinglyLinkedList;

class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
	
	static SortableList ans;
	SortableList list1;
	SortableList list2;

	public SortableList() {
		super();
	}
	
	void divide() {
		list1 = new SortableList<T>();
		list2 = new SortableList<T>();
    	int size = this.getSize();
    	Entry<T> cur = this.head.next;
    	int i = 0;
    	for(i = 0; i < size / 2; i++) {
    		list1.add(cur.element);
    		cur = cur.next;
    	}
    	for(int j = i; j < size; j++) {
    		list2.add(cur.element);
    		cur = cur.next;
    	}
    }
	
    void mergeSort()  { // Sort this list
    	if(ans == null) ans = new SortableList<T>();
    	if(this.getSize() < 2) {
    		for(Object element: this) {
    			ans.add(element);
    		}
    		ans.printList();
    		return;
    	}
    	if(this.getSize() == 2) {
    		SortableList temp = new SortableList();
    		if(this.head.next.element.compareTo(this.tail.element) > 0) {
    			temp.add(this.tail.element);
    			temp.add(this.head.next.element);
    		} else {
    			temp.add(this.head.next.element);
    			temp.add(this.tail.element);
    		}
    		ans.merge(temp);
    		ans.printList();
    		return;
    	}
    	if(this.getSize() > 2) {
    		this.divide();
    		this.list1.mergeSort();
    		this.list2.mergeSort();
    		SortableList temp1 = new SortableList();
    		for(Object element: this.list1) {
    			temp1.add(element);
    		}
    		SortableList temp2 = new SortableList();
    		for(Object element: this.list2) {
    			temp2.add(element);
    		}
    		temp1.merge(temp2);
    		ans.merge(temp1);
    		ans.printList();
    		return;
    	}
    }
    
    void merge(SortableList<T> otherList) {  // Merge this list with other list
    	Entry<T> head1 = this.head;
    	Entry<T> tail1 = this.tail;
		Entry<T> head2 = otherList.head;
		Entry<T> tail2 = otherList.tail;
		Entry<T> cur = new Entry<T>(null, null);
		super.head = cur;
		Entry<T> cur1 = head1.next;
		Entry<T> cur2 = head2.next;
		while(cur1 != null && cur2 != null) {
			if(cur1.element.compareTo(cur2.element) < 0) {
				cur.next = cur1;
				cur1 = cur1.next;
			} else {
				cur.next = cur2;
				cur2 = cur2.next;
			} 
			cur = cur.next;
		}
		while(cur1 != null && tail1 != null && cur1 != tail1.next) {
			cur.next = cur1;
			cur1 = cur1.next;
			cur = cur.next;
		}
		while(cur2 != null && tail2 != null && cur2 != tail2.next) {
			cur.next = cur2;
			cur2 = cur2.next;
			cur = cur.next;
		}
		return;
    }
    
    
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> list) {
    	list.mergeSort();
    }
    
}
