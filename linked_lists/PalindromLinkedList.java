package linked_lists;

// #1: Reverse 2nd half of list and compare it with 1st half of list
// #2: Stack => same approach 'runner'; push 1st half to stack, pop and match with 2nd half
// #3: use Recursion

// Approach #1 is used during below implementation.
public class PalindromLinkedList {

	Node secondHalf;
	
	public static void main(String[] args) {
		PalindromLinkedList palin = new PalindromLinkedList();
		CustomLinkedList<Character> custll = new CustomLinkedList<Character>();
		custll.add('R');
		custll.add('A');
		custll.add('D');
		custll.add('P');
		custll.add('A');
		custll.add('R');
		Node custllHead = custll.getHead(); 
		
		// return true when linkedlist is empty or has single element (E.g. [], [1])
		if(custllHead == null || custllHead.next == null) {
			System.out.println("Is Palindrome:"+ "true");
		}
		
		palin.reverseLinkedList(custllHead);
		boolean result = palin.isPalindrome(custllHead, palin.secondHalf);
		System.out.println("Is Palindrome:"+result);
	}

	private boolean isPalindrome(Node custllHead, Node prev) {
		
		while (custllHead != null && prev != null) {
			if(custllHead.data != prev.data) {
				return false;
			}		
			custllHead = custllHead.next;
			prev = prev.next;
		}
		
		/* return true if both lists are empty here*/
		return(custllHead == null && prev == null);
	}

	private Node reverseLinkedList(Node head) {
		Node slow = head;
		Node fast = head;
		Node midNode;
		Node prevOfSlow;
		
		while(fast != null && fast.next != null) {
			prevOfSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// if size is odd
		if(fast != null) {
			midNode = slow;		// midNode need to be ignored for odd sized LinkedLists
			slow = slow.next;
		}
		
		secondHalf = slow;
		prevOfSlow.next = null; // prevOfSlow.next = midNode (in case of odd)
		
		// reverse 2nd half of list
		secondHalf = reverse();		
		return secondHalf;
	}

	private Node reverse() {

		Node current = secondHalf;
		Node prev = null;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
