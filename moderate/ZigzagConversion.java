package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

	P   A   H   N			1		5		9		13
	A P L S I I G			2	4	6	8	10	12	14
	Y   I   R				3		7		11

And then read line by line: "PAHNAPLSIIGYIR"
---------
n=3 -> 4
---------
 1	 2	 3	 4
(P)	(A)	(Y)	(P)
 5	 6	 7	 8
(A)	(L)	(I) (S)
 9	10	11	12
(H)	(I) (R) (I)
13	14 
(N) (G) 

--------
n=4 -> 6
--------						
1	2	3	4	5	6			P			I			N				1			7			13
P 	A	Y	P	A	L	.	.	A		L	S		I	g		==>		2		6	8		12	14
7	8	9	10	11	12	  .		Y	A		H	R						3	5		9	11
I	S	H	I	R	I			P			I							4			10
13	14
N	G

--------
n=5 -> 8
---------
										P				H				1				9
1	2	3	4	5	6	7	8			A			S	I				2			8	10
P	A	Y	P	A	L	I	S	.	.	Y		I		R		==>		3		7		11
9	10	11	12	13	14	15	16	  .		P	L			I	G			4	6			12	14
H	I	R	I	N	G					A				N				5				13

---------
n=6 -> 10
---------								
 * */

public class ZigzagConversion {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		int numRows = 5;
		
		String fin = convert(str, numRows);
		System.out.println(fin);
	}

	private static String convert(String str, int numRows) {
		if (numRows == 1) {
			return str;
		}

		int splitter = numRows + (numRows - 2);

		// storing original string to StringBuffer by adding # as delimiter to recognize boundaries
		StringBuffer sb = new StringBuffer();
		int counter = 0;

		for (int p = 0; p < str.length(); p++) {
			counter++;
			sb.append(str.charAt(p));
			if (counter % splitter == 0)
				sb.append('#');
		}
//		String[] s1 = {"P","A","Y","P","A","L"};
//		String[] s2 = {"I","S","H","I","R","I"};
//		String[] s3 = {"N","G"};

		// storing separate String segment to List
		String[] s = sb.toString().split("#");
		List<String> list = new ArrayList<>();

		int elem = 0;
		while (elem < s.length) {
			list.add(s[elem]);
			elem++;
		}

		StringBuilder resultant = new StringBuilder();
		int i = 0;

		while (i <= splitter / 2) {
			for (String strA : list) {
				if (splitter / 2 != i) {
					if (i < strA.length()) {
						resultant.append(strA.charAt(i));
					}
					if (splitter - i < strA.length()) {
						resultant.append(strA.charAt(splitter - i));
					}
				} else {
					if (splitter - i < strA.length()) {
						resultant.append(strA.charAt(i));
					}
				}
			}
			i++;
		}
		return resultant.toString();
	}
}
