package arrays_n_strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OneAway {

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "ple";
		
		boolean isOneAway = oneEditAway(s1, s2);
		boolean isOneAwayArr = oneEditAwayUsingArr(s1, s2);

		System.out.println(isOneAway);
	}

	private static boolean oneEditAwayUsingArr(String s1, String s2) {
		
		int i = 0;
		int j = 0;
		int[] awayArr = new int[128];
		int[] awayArr2 = new int[128];

		while(i<s1.length()){
			char c = s1.charAt(i);
			awayArr[c]++;
			i++;
		}
		
		while(j<s2.length()){
			char c = s2.charAt(j);
			
			// if visited earlier in S1
			if (awayArr[c] > 0) {
				awayArr[c]--;
			}
			else { // if new char found in S2
				awayArr2[c]++;
			}
			
			j++;
		}
		
		int count = 0;
		for (int k = 0; k < awayArr2.length; k++) {
			 awayArr[k]+=awayArr2[k];
		}
		
		List<Integer> intList = Arrays.stream(awayArr).boxed().collect(Collectors.toList());
		List<Integer> nonZeroIntList = intList.stream().filter(x-> x>0).collect(Collectors.toList());
		for(int p : nonZeroIntList) {
			count+=nonZeroIntList.get(p);
		}
		return (count<=2);
	}

	private static boolean oneEditAway(String s1, String s2) {
		if(s1.length() == s2.length()) {
			return oneEditReplace(s1, s2);
		} else if(s1.length()+1 == s2.length()) { 
			return oneEditInsert(s1, s2);
		} else if(s1.length()-1 == s2.length()) {
			return oneEditInsert(s2, s1);
		}
		
		return false;
	}

	private static boolean oneEditInsert(String s1, String s2) {
		int idx1 = 0;
		int idx2 = 0;
		
		while(idx1<s1.length() && idx2<s2.length()) {
			if (s1.charAt(idx1) != s2.charAt(idx2)) {
				if(idx1 != idx2) {
					return false;
				}
				idx2++;
			} else {
				idx1++;
				idx2++;
			}
		}
		return true;
	}

	private static boolean oneEditReplace(String s1, String s2) {
		boolean flag = false;
		for (int idx = 0; idx < s1.length(); idx++) {
			if (s1.charAt(idx) != s2.charAt(idx)) {
				if (flag) {
					// 2nd time non matching char
					return false;
				}
				flag = true;
			}
		}
		return true;
	}
}
