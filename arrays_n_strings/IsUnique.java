package arrays_n_strings;

import java.util.Arrays;
import java.util.BitSet;

public class IsUnique {

	public static void main(String[] args) {
		
		IsUnique obj = new IsUnique();
		int[] arr = new int[] {3,4,0,0,2,3,1,9};
		
		boolean flag = obj.isUniqueBitSet(arr);
		System.out.println("\n"+Arrays.toString(arr));
		System.out.println("Is unique? "+flag);
	}

	// using boolean array
	private boolean isUnique(int[] arr) {
		boolean[] bool = new boolean[10];
		boolean flag = true;
		for (int k = 0; k < arr.length; k++) {

			int val = arr[k];
			// value found
			if (bool[val]) {
				System.out.print(val+" ");	 //prints duplicate element
				flag = false;
			}
			bool[val] = true;
		}
		return flag;
	}
	
	// using BitSet (java.util.BitSet)
	private boolean isUniqueBitSet(int[] arr) {
		boolean flag = true;

		BitSet bitSet = new BitSet(arr.length);
		for (int k = 0; k < arr.length; k++) {
			if (bitSet.get(arr[k])) {
				System.out.print(arr[k]+" ");		//prints duplicate element  
				flag = false;
			} else {
				bitSet.set(arr[k]);
			}
		}

		return flag;
	}
}
