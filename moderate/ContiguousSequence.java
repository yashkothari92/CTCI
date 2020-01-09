package moderate;
/**
 * Given an array, find contiguous sequence with largest sum, Return the sum.
 * */

public class ContiguousSequence {

	public static void main(String[] args) {
		
		//int A[] = { 2, -8, 3, -2, 4, -10};
        int A[] = { -2, -3, 4, -1, -2, 1, 5, -3 }; 
		//int A[] = { 2, 3, -8, -1, 2, 4, -2, 3};
		
		String largestSum = findLargestSum(A);
		String[] info = largestSum.split(",");
		System.out.println("Largest sum is ["+info[0]+"] starting from index "+info[1]+" and ending at "+info[2]);
		
		System.out.print("{");
		for (int i = Integer.parseInt(info[1]); i <= Integer.parseInt(info[2]); i++) {
			System.out.print(A[i] + " ");
		}
		System.out.print("}");

	}

	private static String findLargestSum(int[] a) {
		int s=0, start = 0, end=0;
			
		int sum = 0;
		int maxSum = 0;
		
		for(int i=0; i<a.length; i++) {
			sum += a[i];

			if (maxSum < sum) {
				maxSum = sum;
				start = s;
				end = i;
			} else if(sum < 0){
				sum = 0;
				s = i+1;
			}
		}
		return maxSum+","+start+","+end;
	}
}
