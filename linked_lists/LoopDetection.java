package linked_lists;

public class LoopDetection {
	public static void main(String[] args) {
		CustomLinkedList<Character> cll2 = new CustomLinkedList<Character>();
		cll2.add('A');
		cll2.add('B');
		cll2.add('C');
		cll2.add('D');
		cll2.add('E');
		cll2.add('C');
		
		Node cll2Head = cll2.getHead();
		int cll2Size = cll2.getSize();
		System.out.println();
	}
}
