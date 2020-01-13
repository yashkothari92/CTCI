
package moderate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SumSwap {
	
	public static void main(String[] args) {
		SumSwap swap = new SumSwap();
		 int[] arrayA = {4, 1, 2, 1, 1, 2};
		 int[] arrayB = {3, 6, 3, 3};
		 
		 int[] values = swap.sumSwap(arrayA, arrayB); 
		 // using sorting: O(AlgA + BlgB)
		 // using hashSet: O(A + B)
		 System.out.println(Arrays.toString(values));
	}

	private int[] sumSwap(int[] arrayA, int[] arrayB) {
		int sumA = sum(arrayA);		//O(n)
		int sumB = sum(arrayB);		//O(n)
		/**
		 * By math, 
		 * sumA - a + b = sumB - b + a;
		 * sumA - sumB  = 2a - 2b;
		 * a - b = (sumA - sumB) / 2 ; 
		 * 
		 * e.g. a - b = -2; (in this current example)
		 * */
		
		int targetDiff = (sumA - sumB)/2;		
		/*
		Set<Integer> mySet = buildSet(arrayB);
		
		// need to find other element by looking into the set while traversing another arrayB
		
		for (int a = 0; a < arrayA.length; a++) {
			if(mySet.contains(arrayA[a]-targetDiff)) {
				int values[] = {arrayA[a], (arrayA[a]-targetDiff)};
				return values;
			}
		}
		
		return null;
		*/
		
		return findValsBySorting(arrayA, arrayB, targetDiff); 	// O(nlgn)
	}

	private int[] findValsBySorting(int[] arrayA, int[] arrayB, int diff) {
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		int a =0, b= 0;
		while (a < arrayA.length && b < arrayB.length) {
			if (arrayA[a] - arrayB[b] == diff) {
				return new int[] { arrayA[a], arrayB[b] };
			}
			a++;
			b++;
		}
		return null;
	}

	private Set<Integer> buildSet(int[] arrayA) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i: arrayA) {
			set.add(i);
		}
		
		return set;
	}

	private int sum(int[] array) {
		int sum = 0;
		for(int i = 0; i< array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
}
