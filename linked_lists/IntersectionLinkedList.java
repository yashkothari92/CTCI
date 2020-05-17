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
	
	private static Node findIntersectNode(Node l1Head, Node l2Head) {
		// get the size of both the linkedlists
		int l1Size = findSize(l1Head);
		int l2Size = findSize(l2Head);
		
		int diff = 0;
		// advance bigger linkedlist by {diff} steps
		if (l1Size < l2Size) {
			diff = l2Size - l1Size;
			while(diff > 0) {
				l2Head = l2Head.next;
				diff --;
			}
		} else {
			diff = l1Size - l2Size;
			while(diff > 0) {
				l1Head = l1Head.next;
				diff --;
			}
		}
		
		while (l1Head != null && l2Head != null) {
			if(l1Head == l2Head) {	//instead of checking its value/data, check its reference
				return l1Head;
			}
			l1Head = l1Head.next;
			l2Head = l2Head.next;
		}
		
		return null;
	}

	private static int findSize(Node lHead) {
		int counter = 0;
		while(lHead != null) {
			counter++;
			lHead = lHead.next;
		}
		return counter;
	}
}
