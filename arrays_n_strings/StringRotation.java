package arrays_n_strings;

public class StringRotation {

	public static void main(String[] args) {
		
		String s1 = "waterbottle";
		String s2 = "ttlewaterbo";
		
		// determine if s2 is rotation of s1
		boolean rotated = isStringRotated(s1, s2);
		System.out.println("rotated: "+rotated);
	}

	private static boolean isStringRotated(String s1, String s2) {
		// if size mismatch
		if (s1.length() != s2.length() && s1.length() > 0 && s2.length() > 0) {
			return false;
		}
		
		String s1s1 = s1 + s1;
		
		return isSubString(s1s1, s2);
	}

	private static boolean isSubString(String s1s1, String s2) {
		//System.out.println(s1s1 +", "+s2);
		return s1s1.contains(s2);
	}
}
