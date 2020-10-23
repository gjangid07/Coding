package Queue;

import java.util.ArrayList;
import java.util.List;

public class testt {
	
	public static void main(String[] args) {
		
		List l = new ArrayList();
		l.add(3);
		l.add(1);
		l.add(7);
		l.add(2);
		l.add(9);
		
		System.out.println(sort(l));
	}
	
	 public static List<Integer> sort(List<Integer> toSortArray) {
	       return sort(toSortArray, 0 , toSortArray.size()-1);
	        
	    }

	    public static List<Integer> sort(List<Integer> toSortArray, int low, int high) {
	     if (low < high) 
	        { 
	            
	            int pi = partition(toSortArray, low, high); 
	  
	            sort(toSortArray, low, pi-1); 
	            sort(toSortArray, pi+1, high); 
	        } 
	        return toSortArray;
	    }

	    public static int partition(List<Integer> toSortArray, int low, int high) 
	    { 
	        int pivot = toSortArray.get(high);  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	           
	            if (toSortArray.get(j) <= pivot) 
	            { 
	                i++; 

	                int temp = toSortArray.get(i); 
	                toSortArray.set(i, toSortArray.get(j));
	                toSortArray.set(j, temp);
	               
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 

	        int temp = toSortArray.get(i+1); 
	        toSortArray.set(i+1, toSortArray.get(high));
	        toSortArray.set(high, temp);
	  
	        return i+1; 
	    } 

}
