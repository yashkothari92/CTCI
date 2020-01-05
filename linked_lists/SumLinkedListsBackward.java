package linked_lists;

class PartialHolder {
	Node sum = null;
	int carry = 0;
}
public class SumLinkedListsBackward {
	static Node head;

	public static void main(String[] args) {
		CustomLinkedList<Integer> custll = new CustomLinkedList<Integer>();
		// case 1: Linked List are stored in reverse order : 617 represented as 7 -> 1 > 6
		
		custll.add(7);
		custll.add(1);
		custll.add(6);
		Node custllHead = custll.getHead(); 
		int custllSize = custll.getSize();
		System.out.println();
		
		CustomLinkedList<Integer> custll2 = new CustomLinkedList<Integer>();
		custll2.add(5);
		custll2.add(9);
		//custll2.add(2);
		Node custll2Head = custll2.getHead();
		int custll2Size = custll2.getSize();
		System.out.println();
		
		Node custLL1Node = custll.getHead();
		Node custLL2Node = custll2.getHead();
		
		System.out.println("addition of LinkedList1 & LinkedList2 (reverse)");
		Node addRev = addLinkedListReverse(custLL1Node, custLL2Node);
		while(addRev != null) {
			System.out.print(addRev.data + " ");
			addRev = addRev.next;
		}
	}

	private static Node addLinkedListForward(Node custLL1Node, Node custLL2Node) {
		// find Lenght of each LinkedList 
		int len1 = length(custLL1Node);
		int len2 = length(custLL2Node);
		
		// pad shorter LinkedList with zeros()
		if(len1 < len2) {
			padListFront(custLL1Node, len2 - len1);
		} else if(len2 < len1) {
			padListFront(custLL2Node, len1 - len2);	
		}
		
	//	addLinkedListFwd();
		
		PartialHolder holder = new PartialHolder();
		int sum = 0;
		
		if (custLL1Node == null && custLL2Node == null) {
			return holder.sum; 			//0
		}
			
		int val =  holder.carry + (Integer)custLL1Node.data + (Integer)custLL2Node.data ;
		addLinkedListForward(custLL1Node.next, custLL1Node.next);
		
		return null;
	}
	
	private static Node padListFront(Node node, int i) {
		while(i>0) {
			node = insertBefore(node, 0);
			i--;
		}
		return node;
	}

	private static Node insertBefore(Node node, int i) {
		Node paddedNode = new Node(i);
		paddedNode.next = node;
		return paddedNode;
	}

	private static int length(Node node) {
		int counter = 0;
		while (node != null) {
			node = node.next;
			counter++;
		}
		return counter;
	}

	private static Node addLinkedListReverse(Node custLL1Node, Node custLL2Node) {
		// find Length of each LinkedList 
		int len1 = length(custLL1Node);
		int len2 = length(custLL2Node);
		
		// pad shorter LinkedList with zeros()
		if(len1 < len2) {
			custLL1Node = padListBack(custLL1Node, len2 - len1);
		} else if(len2 < len1) {
			custLL2Node = padListBack(custLL2Node, len1 - len2);	
		}
		
		int carry = 0;
		int sum = 0;
		
		while(custLL1Node != null && custLL2Node != null) {
			int val = carry + (Integer)custLL1Node.data + (Integer)custLL2Node.data;
			
			sum = val%10;
			// append sum at last node
			appendNode(sum);
			
			// store 'carry', and use it the same in next action 
			if(val > 10) {
				carry = val/10;
			}
			custLL1Node = custLL1Node.next;
			custLL2Node = custLL2Node.next;	
		}
		return head;		
	}

	private static Node padListBack(Node node, int i) {
		while(i>0) {
			node = insertAfter(node, 0);
			i--;
		}
		return node;
	}

	private static Node insertAfter(Node node, int i) {
		Node current = node;
		Node paddedNode = new Node(i);
		while(current.next != null) {
			current = current.next;
		}
		current.next = paddedNode;
		paddedNode.next = null;
		return node;
	}

	private static void appendNode(int sum) {
		Node newNode = new Node(sum);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node lastNode = findLastNode(head);
		lastNode.next = newNode;
		newNode.next = null;
		return;
	}

	private static Node findLastNode(Node head) {
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}
}
