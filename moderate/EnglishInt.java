package moderate;

import java.util.LinkedList;

public class EnglishInt {

	static String units[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	
	static String tens[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
						"Eighteen", "Nineteen"};
	
	static String[] ten_multipliers = {"", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	static String[] big = {"", "thousand", "million"}; 
	
	public static void main(String[] args) {
		
		int number = 0;
		String english = convertToWord(number);
		System.out.println(english);
	}

	private static String convertToWord(int number) {
		LinkedList<String> parts = new LinkedList<String>();
		String word = null ;
		
		int num_length = String.valueOf(number).length();
		
		// if number length is zero, returns null
		if(num_length == 0) {
			return null;
		}
		
		// if single digit number, return array[digit]
		if(num_length == 1) {
			return units[number%10];
		}

		int chunkCount = 0;
		while(number > 0) {
			if(number % 1000 != 0) {
				word = convertChunk(number % 1000) + big[chunkCount];
				parts.addFirst(word);
			}
			number = number/1000;
			chunkCount++;
		}
		
		return listToString(parts);
	}

	private static String convertChunk(int n) {
		LinkedList<String> chunks = new LinkedList<String>();
		// convert hundreds place - 877
		if(n >= 100) {
			chunks.addLast(units[n / 100]);
			chunks.addLast("hundred");
			n = n % 100;
		}
		
		// convert tens place - 77	
		if(n>=10 && n<=19) {
			chunks.addLast(tens[n % 10]);
		} else if(n>=20) {
			chunks.addLast(ten_multipliers[n / 10]);
			n = n % 10;
		}
		
		// convert unit digit - 7
		if(n>=1 && n<=9) {
			chunks.addLast(units[n%10]);
		}
		
		return listToString(chunks);
	}

	private static String listToString(LinkedList<String> chunks) {
		StringBuilder builder = new StringBuilder();
		while(chunks.size() > 0) {
			builder.append(chunks.pop());
			builder.append(" ");
		}
		
		return builder.toString();
	}
}
