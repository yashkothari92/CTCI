package arrays_n_strings;

import java.util.Arrays;
import java.util.BitSet;

public class IsUnique {

	public static void main(String[] args) {
		
		IsUnique obj = new IsUnique();
		int[] arr = new int[] {3,4,5,0,2,7,1,9};
		
		boolean flag = obj.isUnique(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Is unique? "+flag);
	}

	// using boolean array
	private boolean isUnique(int[] arr) {
		boolean[] bool = new boolean[10];

		for (int k = 0; k < arr.length; k++) {

			int val = arr[k];
			// value found
			if (bool[val]) {
				return false;
			}
			bool[val] = true;
		}
		return true;
	}
	
	// using BitSet (java.util.BitSet)
	private boolean isUniqueBitSet(int[] arr) {
		boolean flag = true;

		BitSet bitSet = new BitSet(arr.length);
		for (int k = 0; k < arr.length; k++) {
			if (bitSet.get(arr[k])) {
				flag = false;
			} else {
				bitSet.set(arr[k]);
			}
		}

		return flag;
	}
}
