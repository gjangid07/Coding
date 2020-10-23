package BitwiseXOR;

public class BitwiseXOR {

	public static void main(String[] args) {

//		System.out.println(findMissingNumber(new int[] {1,2,3,4,6}));
//		System.out.println(findSingleNumberOutOfDuplicates(new int[] { 7, 9, 7, 9, 8 }));
//		System.out.println(findSingleNumbersOutOfDuplicates(new int[] {2,1,3,2}));

//		System.out.println(complimentOfBase10(12));
		flipHorizontalAndInvert(new int[][] {
			  {1,1,0,0},
			  {1,0,0,1},
			  {0,1,1,1}, 
			  {1,0,1,0}
			});
	}

	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;

		int x1 = 1;
		for (int i = 2; i <= n; i++) {
			x1 = x1 ^ i;
		}

		int x2 = arr[0];

		for (int i = 1; i < arr.length; i++) {
			x2 = x2 ^ arr[i];
		}

		return x1 ^ x2;
	}

	public static int findSingleNumberOutOfDuplicates(int[] arr) {
		int x = arr[0];

		for (int i = 1; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		return x;
	}

	public static int[] findSingleNumbersOutOfDuplicates(int[] arr) {
		int n1Xn2 = arr[0];

		for (int i = 1; i < arr.length; i++) {
			n1Xn2 = n1Xn2 ^ arr[i];
		}

		int rightMostSetBit = 1;

		while ((rightMostSetBit & n1Xn2) == 0) {
			rightMostSetBit = rightMostSetBit << 1;
		}

		int n1 = 0;
		int n2 = 0;

		for (int n : arr) {
			if ((n & rightMostSetBit) != 0) {
				n1 = n1 ^ n;
			} else {
				n2 = n2 ^ n;
			}
		}

		return new int[] { n1, n2 };
	}

	public static int complimentOfBase10(int num) {
		int noOfBits = (int) (Math.log(num) / Math.log(2)) + 1;

		int xor = 0;
		for (int i = 0; i < noOfBits; i++) {
			xor = (int) (xor + Math.pow(2, i));
		}

		return xor - num;

	}

	public static void flipHorizontalAndInvert(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
				matrix[i][matrix[i].length - 1 - j] = tmp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = matrix[i][j] ^ 1;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
	}
}
