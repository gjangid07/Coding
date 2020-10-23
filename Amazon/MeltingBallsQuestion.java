package Amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeltingBallsQuestion {

	public static void main (String[] args) throws Exception {
		findMinCost(new long[] {4,3,2,6});
	}
	
	public static void findMinCost(long[] a) {
		PriorityQueue<Long> q = new PriorityQueue<>();
		
		for(int i = 0 ; i < a.length ; i++) 
			q.add(a[i]);
		
		long cost = 0;
			while(!q.isEmpty() && a.length > 1 && q.size() > 1) {
				long sum = q.remove() + q.remove();
				cost += sum ;
				q.add(sum);
			}
		System.out.println(cost);	
	}
	
	public static void findMinCost1(long[] a) {
		if(a.length==0) {
			return;
		}
		
		if(a.length==1) {
			return;
		}
		
		if(a.length==2) {
			System.out.println(a[0]+a[1]);
		}
		
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++) {
			
		}
	}

}
