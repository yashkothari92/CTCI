package linked_lists;

public class IntersectionLinkedList {

	public static void main(String[] args) {
		CustomLinkedList<Integer> custll = new CustomLinkedList<Integer>();
		/*
		 * custll.add(1); custll.add(4);
		 */
		custll.add(5);
		custll.add(1);
		custll.add(6);
		custll.add(0);
		custll.add(8);
		Node custllHead = custll.getHead(); 
		int custllSize = custll.getSize();
		System.out.println();
		
		CustomLinkedList<Integer> custll2 = new CustomLinkedList<Integer>();
		custll2.add(2);
		custll2.add(5);
		custll2.add(6);
		custll2.add(7);
		custll2.add(3);
		custll2.add(8);
		custll2.add(0);
		Node custll2Head = custll2.getHead();
		int custll2Size = custll2.getSize();
		System.out.println();
		
		Node shared = findIntersectNode(custllHead, custll2Head, custllSize, custll2Size);
		if (shared != null)
			System.out.println("Intesect node: "+shared.data);
		else
			System.out.println("Oops...No matching intersect node found! ");
	}
	
	
	public static Node findIntersectNode(Node head1, Node head2, int custllSize, int custll2Size) {
		// if same length, increment both and return when both points to same Node 		==> O(n)
		if(custllSize == custll2Size) {
			while(head1 != null && head2 != null) {
				if(head1.data == head2.data) {
					return head1;
				}
				head1 = head1.next;
				head2 = head2.next;
			}
		} else {
			int m = Math.abs(custllSize - custll2Size);
			//int bigger = m > 0 ? custllSize : custll2Size;
			
			// advance bigger linked list by 'm', and later increment both together ==> O(m) [where m<n]
			if(custllSize > custll2Size) {
				while (m > 0) {
					head1 = head1.next;
					m--;
				}
			} else {
				while (m > 0) {
					head2 = head2.next;
					m--;
				}
			}
			
			// now both linked list, points to same position						==>	O(n-m)
			
			while(head1 != null && head2 != null) {
				if(head1.data == head2.data) {
					return head1;
				}
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return null;
	}
	
}
