package linked_lists;

//	3	-> 	6	->	2	->	7	->	9	->	1	-> 	3  	... 7
//	3	-> 	6	->	5	->	2	->	1	-> 	3  			... 2
public class DeleteMiddleNode {

	public static void main(String[] args) {		
		CustomLinkedList<Integer> ll = new CustomLinkedList<Integer>();
		ll.add(3);
		ll.add(6);
		ll.add(5);
		ll.add(2);
		ll.add(1);
		ll.add(8);
		
		Node nodeToBeDeleted = ll.getNode(8);
		deleteMiddleNode(nodeToBeDeleted);
		ll.traverse();
	}

	private static void deleteMiddleNode(Node nodeToBeDeleted) {
		/**
		 * using 2 pointers (slow & fast) to identify middle node
		 
		Node fast = head;
		Node slow = fast;
		
		while(fast.next != null) {
			fast = fast.next;
			
			if (fast != null) {
				fast = fast.next;
			}
			slow = slow.next;
		}
		
		System.out.println(slow.data);
		*/
		
		if (nodeToBeDeleted == null || nodeToBeDeleted.next == null) {
			return;
		}
		
		Node nextNode = nodeToBeDeleted.next;
		nodeToBeDeleted.data = nextNode.data;
		nodeToBeDeleted.next = nextNode.next;
		return;
	}
}
