package cs6301.g18Sp2;

import java.util.ArrayList;
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
	    int j = 0;
        
	    T current1 = l1.get(p1);
	    T current2 = l2.get(p2);
	    
	    
	    while(p1 < l1.size() && p2 < l2.size())
	    {
	    	int b = current1.compareTo(current2);
	        if(b < 0)
	        {
	        	if(p1 < l1.size() - 1)
	        	{
	        		current1 = l1.get(p1+1);
	        		p1 = p1 + 1;
	        	}
	        	
	        }else if(b > 0)
	        {
	        	if(p2 < l2.size() - 1)
	        	{
	        		current2 = l2.get(p2+1);
	        		p2 = p2 + 1;
	        	}
	        }else{
	            
	        	outList.add(j, current1);
	        	j++;
	        	
	            if(p1 < l1.size() - 1 && p2 < l2.size() - 1)
	            {	  	
	            	current1 = l1.get(p1+1);
	            	current2 = l2.get(p2+1);
		            p1 = p1 + 1;
			        p2 = p2 + 1;
	            } 
	        }
	    }
	
	    return;
	}
	
	//@SuppressWarnings("null")
	public static List<Integer> readList(Scanner in)
	{
		int i = 0;
		List<Integer> l = new ArrayList<Integer>();
		
		while(in.hasNextInt())
		{
			l.add(i, in.nextInt());
			i++;
		}
		return l;
			
	}

	public static <T extends Comparable<? super T>> void main(String[] args) throws FileNotFoundException 
	{
		
		List<Integer> outList = new ArrayList<Integer>();

		File list1 = new File("list1.in");
		Scanner in1 = new Scanner(list1);
		File list2 = new File("list2.in");
		Scanner in2 = new Scanner(list2);
		
		List<Integer> l1 = readList(in1);
		List<Integer> l2 = readList(in2);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println("start");
		LinkedListImplement.intersect(l1, l2, outList);
		System.out.println(outList);
		System.out.println("done");


	}

}
