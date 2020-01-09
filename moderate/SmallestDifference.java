package moderate;

import java.util.Arrays;

/**
 * 16.6 Smallest difference:
 * 		Given two arrays of integers, 
 * 		compute the pair of values (one value in each array) with the smallest (non-negative) difference. 
 * 		Return the difference & pair. 
 * */
public class SmallestDifference {

	public static void main(String[] args) {
		
		int A[] = {10, 5, 40};
		int B[] = {50, 90, 80};
		
	//	int A[] = {1, 3, 15, 11, 2};
	//  int B[] = {23, 127, 235, 19, 8}; 
		
	//	int A[] = {1, 2, 11, 5};
    //  int B[] = {4, 12, 19, 23, 127, 235};
        
        //sort arrays - O (n*logn)
        Arrays.sort(A);
        Arrays.sort(B);
        
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        
        findSmallestDifference(A, B);
	}

	private static void findSmallestDifference(int[] a, int[] b) {
		int idx1 = 0;
		int idx2 = 0;
		int min = Integer.MAX_VALUE;
		String pair = null;
		
		// iterate over both array and compare
		while (idx1 < a.length && idx2 < b.length) {
			int diff = Math.abs(a[idx1] - b[idx2]);
			if(diff < min) {
				min = diff;
				pair = a[idx1] +" , "+ b[idx2];
				
			}
			
			// move smaller number
			if (a[idx1] < b[idx2]) {
				idx1++;
			} else {
				idx2++;
			}
		}
		
		System.out.println("Minimum difference of "+min + " of pair: ("+pair+")");
	}
	
}
