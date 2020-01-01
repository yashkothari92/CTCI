package xcustom;

public class StringVsBuilder {

	public static void main(String[] args) {
		int num = 100000;
		String str = "";
		StringBuilder builder = new StringBuilder();
		
		long startB = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			builder.append(i);
		}
		long endB = System.currentTimeMillis();
		System.out.println("time by StringBuilder is: "+(endB - startB));
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			str+=i;
		}
		long end = System.currentTimeMillis();
		System.out.println("time by String is: "+(end - start));
	}
}
