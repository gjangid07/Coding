package Arrays;

import java.util.Arrays;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
//		Arrays.stream(SubArrayWithGivenSumMethod2(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 12))
//		.forEach(i -> System.out.print(i+","));
		
//		System.out.println(Math.pow(62, 5));
		
		tinyURLConversion("dcba");
		
		
	}

	private static void tinyURLConversion(String str) {
		char[] chars = str.toCharArray();
		
		int value =1;
		
		for(char ch: chars) {
			value = 62*value*ch;
		}
		
		System.out.println(value);
		
	}

	public static int[] SubArrayWithGivenSumMethod(int[] arr, int s) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			start = i+1;
			int sumRem = s;
			for (int j = i; j < arr.length; j++) {
				if (sumRem == 0) {
					end = j;
					return new int[] { start, end };
				}
				sumRem -= arr[j];
			}
		}
		return new int[] { start, end };
	}
	
	public static int[] SubArrayWithGivenSumMethod2(int[] arr, int s) {
		
		int start = 0;
		int end = 0;
		int curr_sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			curr_sum+=arr[i];
			
			while(curr_sum>s && start<i) {
				curr_sum = curr_sum - arr[start];
				start++;
			}
			
			if(curr_sum==s) {
				return new int[] { start+1, i+1 };
			}
		}
		
		return new int[] { start, end };
	}
}
