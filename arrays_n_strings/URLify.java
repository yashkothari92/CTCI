package arrays_n_strings;

public class URLify {

	public static void main(String[] args) {
		
		String input = "Mr John Smith";
	//	transURLbyReplaceAll(input);
		transURLinPlace(input.toCharArray());
	}

	private static void transURLbyReplaceAll(String input) {
		input = input.replaceAll("\\s", "%20");
		System.out.println(input);
	}
	
	private static void transURLinPlace(char[] input) {
	//	StringBuilder builder = new StringBuilder(input);
		int spaceCnt = 0;
		
		for(int i=0; i<input.length; i++) {
			if(input[i]==' ') {
				spaceCnt ++;
			}
		}
		
		int index = input.length + spaceCnt*2;
		
		// resizing array to accommodate %20 by copying old char array to newer one and later renaming those
		char[] input2 = new char[index]; //input;
		for(int i = 0; i<input.length; i++) {
			input2[i] = input[i];
		}
		
		// renaming variable to align with
		char[] oldInput = input;
		input = input2;
		
		for(int j = input.length-1; j>=0; j--) {
			if(input[j] ==' ') {
				input[index - 3] = '%';
				input[index - 2] = '2';
				input[index - 1] = '0';
				index = index - 3;
			} else {
				input[index - 1] = input[j];
				index --;
			}
		}
	}
}
