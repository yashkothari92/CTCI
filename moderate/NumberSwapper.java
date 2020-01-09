package moderate;

/**
 * 16.1		function to swap 2 numbers (w/o temporary variable)
 * */

class SwapperHolder {
	Object a;
	Object b;	
	
	public SwapperHolder(Object a, Object b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "a : "+a+"\tb: "+b;
	}
}

public class NumberSwapper {

	public static void main(String[] args) {
		char a = 'y';
		char b = 'h';
		System.out.println("-----Before------");
		System.out.println("a : "+a+"\tb: "+b);
		
		SwapperHolder holder = swapNumbers(a, b);
		System.out.println("-----After------");
		System.out.println(holder);
	}

	private static SwapperHolder swapNumbers(char a, char b) {
		 a= (char) (a^b);
		 b= (char) (a^b);	//({a^b} ^ b)
		 a= (char) (a^b);	//(a ^ {a^b})
		 
		 SwapperHolder holder = new SwapperHolder(a, b);
		 return holder;		 
	}
	
}
