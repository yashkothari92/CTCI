package arrays_n_strings;

public class URLify {

	public static void main(String[] args) {
		
		char[] input = "Mr John Smith      ".toCharArray();
		
		transURLbyReplaceAll(input.toString());
		
		//input = transURLinPlace(input); 
		for(int i=0; i<input.length; i++) {
			  System.out.print(input[i]); 
		}
	}

	private static void transURLbyReplaceAll(String input) {
		input = input.replaceAll("\\s", "%20");
		
	}
	
	private static char[] transURLinPlace(char[] input) {
		int spaceCnt = 0;
		
		// removing trailing spaces here, so later URLify handles original (true) length
		for (int l = input.length - 1; l >= 0; l--) {
			if(input[l] == ' ') {
				input[l] = '\0';
			} else {
				break;
			}
		}
		
		for(int i=0; i<input.length; i++) {
			if(input[i]==' ') {
				spaceCnt ++;
			}
		}
		
		int newLength = input.length + spaceCnt*2;
		
		// resizing array to accommodate %20 by copying old char array to newer one and later renaming those
		char[] input2 = new char[newLength];  //input;
		for(int i = 0; i<input.length; i++) {
			input2[i] = input[i];
		}
		
		// renaming variable
		char[] oldInput = input;
		input = input2;
		
		int index = newLength-1;
		
		// iterate over original char[] passed from main application
		for(int j = oldInput.length-1; j>=0; j--) {
			if(oldInput[j] ==' ') {
				input[index] = '0';
				input[index - 1] = '2';
				input[index - 2] = '%';
				index = index - 3;
			} else {
				// if usual char, store it to new char[] prepared to fit %20 
				input[index] = oldInput[j];
				index --;
			}
		}
		return input;
	}
}
