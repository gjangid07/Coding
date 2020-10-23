package Arrays;

public class EquilibriumIndex {
	
	public static void main(String[] args) {
		EquilibriumIndexUtil(new int[] {1,6,7,0,7});
	}

	public static void EquilibriumIndexUtil(int[] arr) {
		
		int leftSum=0;
		
		for(int i=0;i<arr.length;i++) {
			leftSum+=arr[i];
		}
		
		int rightSum=arr[arr.length-1];
		leftSum = leftSum-arr[arr.length-1]-arr[arr.length-2];
		for(int j=arr.length-2;j>0;j--) {
			if(leftSum==rightSum) {
				System.out.print(j+",");
			}
			leftSum= leftSum-arr[j-1];
			rightSum = rightSum+arr[j];
		}
	}
}
