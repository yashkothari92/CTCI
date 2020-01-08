package arrays_n_strings;

import java.util.HashMap;

public class PalindromPermutation {
	
	public static void main(String[] args) {
		String str = "Never odd or even";
		
		boolean result = isPermuationOfPalindrome(str);
		System.out.println(result);
	}

	private static boolean isPermuationOfPalindrome(String str) {
		str = str.toLowerCase();
	//	HashMap<Character, Integer> table = buildCharFrequencyTable(str);
	//	boolean res = checkMaxOneOdd(table);

		int[] arr = buildCharFrequencyArray(str);
		boolean res = checkMaxOneOdd(arr);
		
		return res;
	}

	private static boolean checkMaxOneOdd(HashMap<Character, Integer> table) {
		int count = 0;

		for(Character key : table.keySet()) {
			if(table.get(key)%2 != 0) {
				count++;
			}
		}	
		return count<=1;
	}

	private static HashMap<Character, Integer> buildCharFrequencyTable(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(str.charAt(i) != ' ') {
				map.put(ch, map.getOrDefault(ch, 0)+1);
			}
		}
		return map;
	}
	
	
	private static int[] buildCharFrequencyArray(String str) {
		int[] freq = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int val = 97;
			if(str.charAt(i) != ' ') {
				freq[ch -val]++;
			}
		}
		return freq;
	}
	
	private static boolean checkMaxOneOdd(int[] arr) {
		int count = 0;

		for(int i=0; i<arr.length; i++) {
			if (arr[i] % 2 != 0) {
				count++;
			}
		}
		return count<=1;
	}
}
