package moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSum {
	public static void main(String[] args) {
		PairsWithSum pair = new PairsWithSum();
		
		int[] A = {4, 1, 2, 3, 0, 9, 8, 2};
		int target = 9;
		
		String pairs = pair.findAllPairUsingList(A, target);
	
	//	Arrays.sort(A);
	//	String pairs = pair.findAllPairsUsingBinSearch(A, 0, A.length, target);
		System.out.println(pairs);
	}

	private String findAllPairUsingList(int[] a, int target) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if(list.contains(a[i])) {
				sb.append(a[i]+","+(target - a[i]));
				sb.append("\n");
			} else {
				list.add(target - a[i]);
			}
		}
		return sb.toString();
	}
	/*
	private String findAllPairsUsingBinSearch(int[] a, int start, int end, int target) {
		StringBuilder sb = new StringBuilder();		
		// now that array is sorted, can use binary search to find compliment
		int mid = start + ( end - start )/ 2;
		for(int i=start; i<end; i++) {
			int complement = target-a[i];
			
			if (complement == a[mid]) {
				sb.append(complement+","+ a[i]);
				sb.append("\n");				
			} else if(complement < a[mid]) {
				findAllPairsUsingBinSearch(a, start, mid-1, target);
			} else {
				findAllPairsUsingBinSearch(a, mid+1, end, target);
			}
		}
		return sb.toString();
	}
	*/
}
