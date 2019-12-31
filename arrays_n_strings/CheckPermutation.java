package arrays_n_strings;

import java.util.Arrays;

// assumptions:
// 1) case insensitive
// 2) ignores whitespace

public class CheckPermutation {

	public static void main(String[] args) {
		CheckPermutation perm = new CheckPermutation();
		
		String s1 = "Coolio";
		String s2 = "Locioo";
		
		boolean outcome = perm.ifPermutaionOfAnotherMatchingFrequency(s1, s2);
		System.out.println(s1+" , "+s2+"\n"+outcome);
	}

	private boolean ifPermutaionOfAnotherUsingSort(String s1, String s2) {
		// if two strings have different length, return false
		if(s1.length() != s2.length()) {
			return false;
		}
		
		// #1: sort two strings & compare
		char[] s1Char = s1.toLowerCase().toCharArray();
		Arrays.sort(s1Char);
		
		char[] s2Char = s2.toLowerCase().toCharArray();
		Arrays.sort(s2Char);
		
		return new String(s1Char).equals(new String(s2Char));
	}
	
	private boolean ifPermutaionOfAnotherMatchingFrequency(String s1, String s2) {
		// if two strings have different length, return false
		if(s1.length() != s2.length()) {
			return false;
		}
		
		// #2: find each character frequency & match
		int[] chars = new int[128];
		for(int i = 0; i<s1.length(); i++) {
			char c = s1.toLowerCase().charAt(i);
			chars[c]++;
		}
		
		for(int i = 0; i<s2.length(); i++) {
			char c = s2.toLowerCase().charAt(i);
			chars[c]--;
			
			// if value goes below 0, that means new character found in s2, and hence won't be permutation of s1
			if(chars[c] < 0) {
				return false;
			}
		}
		// if char[c] will be 0, will return true
		return true;
	}
	
}
