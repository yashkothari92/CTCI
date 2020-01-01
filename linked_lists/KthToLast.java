package linked_lists;

//#1: iterate till Length-K
//#2: Recursive
//#3: Iterative (two pointers P1, P2 (advance till K beforehand))

public class KthToLast {
	
	public static void main(String[] args) {
		CustomLinkedList<Integer> ll = new CustomLinkedList<>();
		ll.add(3);
		ll.add(6);
		ll.add(7);
		ll.add(7);
		ll.add(9);
		ll.add(1);
		ll.add(3);
		
		Node head = ll.getHead();
		int k = 0;
		int size = ll.getSize();

		int data = (int)findKthToLastUsingLength(head, size, k);
		System.out.println("\nKth to Last node: "+data);
	}

	private static Object findKthToLastUsingLength(Node head, int size, int k) {
		
		// if k=0, return last element; else return length-kth element
		int index = k > 0 ? size - k : size - 1;
		int count = 0;

		while (head != null) {
			if (count == index) {
				return head.data;
			}
			head = head.next;
			count++;
		}
		return null;
	}
}
