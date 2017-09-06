package cs6301.g18Sp2;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LinkedListImplement{

	
	public static<T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) 
	{
		Collections.sort(l1);
		Collections.sort(l2);
			
	    int p1=0;
	    int p2=0;
	    
	    T current1 = l1.get(p1);
	    T current2 = l2.get(p2);
	    
	    
	    while(current1 != null && current2 != null)
	    {
	    	int b = current1.compareTo(current2)
	        if(b < 0)
	        {
	        	current1 = l1.get(p1+1);
	        }else if(b > 0)
	        {
	        	current2 = l2.get(p1+1);
	        }else{
	            outList.add(current1);
	            current1 = l1.get(p1+1);
	            current2 = l2.get(p1+1);
	        }
	    }
	
	    return;
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in1;
		Scanner in2;

		File list1 = new File("list1.in");
		in1 = new Scanner(list1);
		File list2 = new File("list2.in");
		in2 = new Scanner(list2);
		
		
		LinkedListImplement L = new LinkedListImplement();
		L.intersect(in1, in2);
		System.out.println(outList);


	}

}
