package com.hacker.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] intArray = {3,30,34,5,9};
		
		String largestNum = getLargestNum(intArray);
		System.out.println(largestNum);
	}

	private static String getLargestNum(int[] intArray) {
		
		if(intArray == null || intArray.length == 0){
			return "";
		}
		String[] str = new String[intArray.length];
		
		for(int k = 0; k<intArray.length; k++){
			str[k] = intArray[k]+"";
		}
		
//		Arrays.sort(str, new Comparator<String>(){
//
//			@Override
//			public int compare(String o1, String o2) {
//				String a = o1+o2;
//				String b = o2+o1;
//				return (a).compareTo(b);
//			}
//		});
		
		Arrays.sort(str, (s1,s2)->(s2+s1).compareTo(s1+s2)); //310, 103
		
		if(str[0].charAt(0) == '0'){
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		for(String s: str)
			sb.append(s);
		
		return sb.toString();
	}
}
