package arrays_n_strings;

public class StringCompression {

	public static void main(String[] args) {
		
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccceaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String compressedStr = compressString(s);
		System.out.println(compressedStr);
	}
	
	private static String compressString(String s) {
		
		// calculate count needed for compressed String beforehand
		int cnt = countCompression(s);
		
		// original string is shorter than compressed one, return shorter one
		if(s.length() < cnt) {
			return s;
		}
		
		StringBuilder compressedStr = new StringBuilder();
		int countConsecutives = 0;
		
		for(int i=0; i<s.length(); i++) {
			countConsecutives++;
			if(i+1>=s.length() || s.charAt(i) != s.charAt(i+1)) {
				compressedStr.append(s.charAt(i));
				compressedStr.append(countConsecutives);
				countConsecutives = 0;
			}
		}
		
		return compressedStr.toString();
	}

	private static int countCompression(String s) {
		int compressedLength = 0;
		int countConsecutive = 0;
		
		for(int i=0; i<s.length(); i++) {
			countConsecutive++;
			
			if ((i+1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedLength+= 1+ String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}	
		}
		
		return compressedLength;
	}

}
