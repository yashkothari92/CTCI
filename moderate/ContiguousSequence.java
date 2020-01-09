package moderate;
/**
 * Given an array, find contiguous sequence with largest sum, Return the sum.
 * */

/*
class ContiguousSeqResult {
	private String seq;
	private int maxSum;
	
	public ContiguousSeqResult(String seq, int maxSum) {
		this.seq = seq.replaceAll(",$", "");
		this.maxSum = maxSum;
	}
	
	@Override
	public String toString() {
		return "Contiguous sequence:("+seq+") with Largest Sum: "+maxSum;
	}
}
*/
public class ContiguousSequence {

	public static void main(String[] args) {
		
		int A[] = { 2, -8, 3, -2, 4, -10};
		//int A[] = { 2, 3, -8, -1, 2, 4, -2, 3};
		
		int largestSum = findLargestSum(A);
		System.out.println(largestSum);
	}

	private static int findLargestSum(int[] a) {
	//	StringBuilder sb = new StringBuilder();
		int sum = 0;
		int maxSum = 0;
		
		for(int i=0; i<a.length; i++) {
			sum += a[i];
			// sb.append(a[i]+","); 

			if (maxSum < sum) {
				maxSum = sum;
			} else if(sum < 0){
				sum = 0;
			//	sb.setLength(0);
			}
		}
		
		return maxSum; //new ContiguousSeqResult(sb.toString(), maxSum);
	}
}
